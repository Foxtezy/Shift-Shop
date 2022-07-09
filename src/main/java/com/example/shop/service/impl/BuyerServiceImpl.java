package com.example.shop.service.impl;

import com.example.shop.repository.BuyerRepository;
import com.example.shop.repository.model.BuyerEntity;
import com.example.shop.service.BuyerService;
import com.example.shop.service.dto.BuyerDto;
import com.example.shop.service.mapper.BuyerMapper;
import javassist.NotFoundException;
import org.omg.CORBA.BAD_OPERATION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BuyerServiceImpl implements BuyerService {
    private final BuyerRepository buyerRepository;

    @Autowired
    public BuyerServiceImpl(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    public BuyerDto findBylogin(String login) throws HttpClientErrorException{
        Optional<BuyerEntity> optionalBuyerEntity = buyerRepository.findById(login);
        if (!optionalBuyerEntity.isPresent()) throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        return BuyerMapper.mapToBuyerDto(optionalBuyerEntity.get());
    }

    public BuyerDto saveBuyerEntity(BuyerEntity buyerEntity) throws HttpClientErrorException {
        if (buyerRepository.existsById(buyerEntity.getLogin())) throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        return BuyerMapper.mapToBuyerDto(buyerRepository.save(buyerEntity));
    }

    public BuyerDto putBuyerEntity(BuyerEntity buyerEntity) throws HttpClientErrorException{
        if (buyerRepository.existsById(buyerEntity.getLogin())) throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        return BuyerMapper.mapToBuyerDto(buyerRepository.save(buyerEntity));
        }

    public void deleteBuyerEntity(String login) throws HttpClientErrorException{
        if (!buyerRepository.existsById(login)) throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        buyerRepository.deleteById(login);
    }

    public List<BuyerDto> getAllBuyerEntity(){
        return ((List<BuyerEntity>)buyerRepository.findAll()).stream().map(BuyerMapper::mapToBuyerDto).collect(Collectors.toList());
    }

    public BuyerDto reduceBuyerEntityBalance(Double reduce, String login) throws ArithmeticException, HttpClientErrorException {
        if (!buyerRepository.existsById(login))  throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        double oldBalance = buyerRepository.findById(login).get().getBalance();
        if (oldBalance < reduce) throw new ArithmeticException();
        BuyerEntity buyerEntity = new BuyerEntity(login,buyerRepository.findById(login).get().getAddress(),oldBalance-reduce);
        return BuyerMapper.mapToBuyerDto(buyerRepository.save(buyerEntity));
    }
}
