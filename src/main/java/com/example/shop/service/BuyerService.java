package com.example.shop.service;

import com.example.shop.repository.model.BuyerEntity;
import javassist.NotFoundException;
import org.omg.CORBA.BAD_OPERATION;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;


public interface BuyerService {
    BuyerEntity findBylogin(String login) throws HttpClientErrorException;
    BuyerEntity saveBuyerEntity(BuyerEntity buyerEntity) throws HttpClientErrorException;
    BuyerEntity putBuyerEntity(BuyerEntity buyerEntity) throws HttpClientErrorException;
    void deleteBuyerEntity(String login) throws HttpClientErrorException;
    List<BuyerEntity> getAllBuyerEntity();
    BuyerEntity reduceBuyerEntityBalance(Double reduce, String login) throws ArithmeticException, HttpClientErrorException;

}
