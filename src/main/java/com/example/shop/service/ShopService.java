package com.example.shop.service;

import com.example.shop.repository.model.ShopEntity;

import java.util.List;

public interface ShopService {
    List<ShopEntity> getProduct(String ware);
}
