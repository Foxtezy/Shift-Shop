package com.example.shop.service;

import com.example.shop.model.StoreDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StoreService {
    ResponseEntity<String> saveNewStore(StoreDto storeDto);
    List<StoreDto> getAllStores();
}
