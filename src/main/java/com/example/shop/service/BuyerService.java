package com.example.shop.service;

import com.example.shop.model.BuyDto;
import com.example.shop.model.OrderInDto;
import com.example.shop.model.OrderOutDto;
import com.example.shop.repository.model.BuyerEntity;
import com.example.shop.model.BuyerDto;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;


public interface BuyerService {
    BuyerDto findByemail(String login) throws HttpClientErrorException;
    BuyerDto saveBuyerEntity(BuyerDto buyerDto) throws HttpClientErrorException;
    BuyerDto putBuyerEntity(BuyerEntity buyerEntity) throws HttpClientErrorException;
    void deleteBuyerEntity(String login) throws HttpClientErrorException;
    List<BuyerDto> getAllBuyerEntity();
    Integer updateBalance(BuyDto buyDto, Double newBalance);
}
