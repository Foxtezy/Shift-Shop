package com.example.shop.service;

import com.example.shop.repository.model.BuyerEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public interface BuyerService {
    ResponseEntity<BuyerEntity> findBylogin(String login);
    ResponseEntity<BuyerEntity> saveBuyerEntity(BuyerEntity buyerEntity);
    public ResponseEntity<String> deleteBuyerEntity(String login);
}
