package com.example.shop.service.impl;

import com.example.shop.repository.ShopRepository;
import com.example.shop.repository.model.ShopEntity;
import com.example.shop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
        return shopRepository.getShopEntityByWare(ware);
    }

    public ResponseEntity<Object> updateAmount(Integer amount, String ware, String store){
        return ResponseEntity.ok(shopRepository.updateAmount(amount, ware, store));
    }

}
