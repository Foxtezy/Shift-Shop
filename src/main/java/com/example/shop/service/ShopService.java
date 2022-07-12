package com.example.shop.service;

import com.example.shop.model.ShopDto;
import com.example.shop.model.StoreByWareDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public interface ShopService {

    ResponseEntity<String> addWareToStore(ShopDto shopDto) throws ResponseStatusException;
    List<StoreByWareDto> getStoresByWare(String ware);
}
