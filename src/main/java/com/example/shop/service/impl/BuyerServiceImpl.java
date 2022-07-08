package com.example.shop.service.impl;

import com.example.shop.repository.BuyerRepository;
import com.example.shop.repository.model.BuyerEntity;
import com.example.shop.service.BuyerService;
import javassist.NotFoundException;
import org.omg.CORBA.BAD_OPERATION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Service
public class BuyerServiceImpl implements BuyerService {
    private final BuyerRepository buyerRepository;

    @Autowired
    public BuyerServiceImpl(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    public BuyerEntity findBylogin(String login) throws HttpClientErrorException{
        Optional<BuyerEntity> optionalBuyerEntity = buyerRepository.findById(login);
        if (!optionalBuyerEntity.isPresent()) throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        return optionalBuyerEntity.get();
    }

    public BuyerEntity saveBuyerEntity(BuyerEntity buyerEntity) throws HttpClientErrorException {
        if (buyerRepository.existsById(buyerEntity.getLogin())) throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        return buyerRepository.save(buyerEntity);
    }

    public BuyerEntity putBuyerEntity(BuyerEntity buyerEntity) throws HttpClientErrorException{
        if (buyerRepository.existsById(buyerEntity.getLogin())) throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        return buyerRepository.save(buyerEntity);
        }

    public void deleteBuyerEntity(String login) throws HttpClientErrorException{
        if (!buyerRepository.existsById(login)) throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        buyerRepository.deleteById(login);
    }

    public List<BuyerEntity> getAllBuyerEntity(){
        return (List<BuyerEntity>)buyerRepository.findAll();
    }

    public BuyerEntity reduceBuyerEntityBalance(Double reduce, String login) throws ArithmeticException, HttpClientErrorException {
        if (!buyerRepository.existsById(login))  throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        double oldBalance = buyerRepository.findById(login).get().getBalance();
        if (oldBalance < reduce) throw new ArithmeticException();
        BuyerEntity buyerEntity = new BuyerEntity(login,buyerRepository.findById(login).get().getAddress(),oldBalance-reduce);
        return buyerRepository.save(buyerEntity);
    }
}
