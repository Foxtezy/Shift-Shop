package com.example.shop.service;

import com.example.shop.repository.model.ShopEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ShopService {
    List<ShopEntity> getProduct(String ware);

    ResponseEntity<Object> updateAmount(Integer amount, String ware, String store);
}
