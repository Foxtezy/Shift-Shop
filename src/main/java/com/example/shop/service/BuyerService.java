package com.example.shop.service;

import com.example.shop.repository.model.BuyerEntity;
import org.springframework.http.ResponseEntity;
import java.util.List;


public interface BuyerService {
    ResponseEntity<BuyerEntity> findBylogin(String login);
    ResponseEntity<BuyerEntity> saveBuyerEntity(BuyerEntity buyerEntity);
    ResponseEntity<String> deleteBuyerEntity(String login);
    List<BuyerEntity> getAllBuyerEntity();
}
