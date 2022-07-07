package com.example.shop.service.impl;

import com.example.shop.repository.BuyerRepository;
import com.example.shop.repository.ShopRepository;
import com.example.shop.repository.model.ShopEntity;
import com.example.shop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;

    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public List<ShopEntity> getProduct(String ware){
        return shopRepository.getShopEntityByWareOrderByWare(ware);
    }
}
