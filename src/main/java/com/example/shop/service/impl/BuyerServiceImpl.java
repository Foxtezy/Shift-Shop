package com.example.shop.service.impl;

import com.example.shop.model.BuyDto;
import com.example.shop.model.OrderInDto;
import com.example.shop.model.OrderOutDto;
import com.example.shop.repository.BuyerRepository;
import com.example.shop.repository.model.BuyerEntity;
import com.example.shop.service.BuyerService;
import com.example.shop.model.BuyerDto;
import com.example.shop.service.mapper.BuyerMapper;
import com.example.shop.service.mapper.OrderInMapper;
import com.example.shop.service.mapper.OrderOutMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class BuyerServiceImpl implements BuyerService {
    private final BuyerRepository buyerRepository;

    private final BuyerMapper buyerMapper;

    private final OrderOutMapper orderOutMapper;

    private final OrderInMapper orderInMapper;

    @Autowired
    public BuyerServiceImpl(BuyerRepository buyerRepository, OrderOutMapper orderOutMapper, BuyerMapper buyerMapper, OrderInMapper orderInMapper) {
        this.buyerRepository = buyerRepository;
        this.orderOutMapper = orderOutMapper;
        this.buyerMapper = buyerMapper;
        this.orderInMapper = orderInMapper;
    }

    public BuyerDto findByemail(String email) throws HttpClientErrorException{
        Optional<BuyerEntity> optionalBuyerEntity = buyerRepository.findById(email);
        if (!optionalBuyerEntity.isPresent()) throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        return buyerMapper.mapToBuyerDto(optionalBuyerEntity.get());
    }

    public BuyerDto saveBuyerEntity(BuyerDto buyerDto) throws HttpClientErrorException {
        BuyerEntity buyerEntity = buyerMapper.mapToBuyerEntity(buyerDto);
        if (buyerRepository.existsById(buyerEntity.getEmail())) throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "This email already busy");
        Pattern pEmail = Pattern.compile("^[A-Za-z0-9]+@[A-Za-z]+[.][A-Za-z]+$");
        Matcher matcher = pEmail.matcher(buyerEntity.getEmail());
        if (!matcher.find()) throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Not email");
        return buyerMapper.mapToBuyerDto(buyerRepository.save(buyerEntity));
    }

    public BuyerDto putBuyerEntity(BuyerEntity buyerEntity) throws HttpClientErrorException{
        if (buyerRepository.existsById(buyerEntity.getEmail())) throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        return buyerMapper.mapToBuyerDto(buyerRepository.save(buyerEntity));
    }

    public void deleteBuyerEntity(String email) throws HttpClientErrorException{
        if (!buyerRepository.existsById(email)) throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        buyerRepository.deleteById(email);
    }

    public List<BuyerDto> getAllBuyerEntity(){
        return ((List<BuyerEntity>)buyerRepository.findAll()).stream().map(buyerMapper::mapToBuyerDto).collect(Collectors.toList());
    }

    public Integer updateBalance(BuyDto buyDto, Double newBalance){
        return buyerRepository.updateBalance(buyDto.getEmail(), newBalance);
    }




}
