package com.example.shop.service;

import com.example.shop.repository.model.BuyerEntity;
import com.example.shop.service.dto.BuyerDto;
import javassist.NotFoundException;
import org.omg.CORBA.BAD_OPERATION;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;


public interface BuyerService {
    BuyerDto findBylogin(String login) throws HttpClientErrorException;
    BuyerDto saveBuyerEntity(BuyerEntity buyerEntity) throws HttpClientErrorException;
    BuyerDto putBuyerEntity(BuyerEntity buyerEntity) throws HttpClientErrorException;
    void deleteBuyerEntity(String login) throws HttpClientErrorException;
    List<BuyerDto> getAllBuyerEntity();
    BuyerDto reduceBuyerEntityBalance(Double reduce, String login) throws ArithmeticException, HttpClientErrorException;

}
