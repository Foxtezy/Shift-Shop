package com.example.shop.service;

import com.example.shop.model.StoreDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public interface StoreService {
    ResponseEntity<String> saveNewStore(StoreDto storeDto);
    void deleteStore(String store) throws ResponseStatusException;
    List<StoreDto> getAllStores();
}
