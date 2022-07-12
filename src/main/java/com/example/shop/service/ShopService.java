package com.example.shop.service;

import com.example.shop.model.ShopDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

public interface ShopService {

    ResponseEntity<String> addWareToStore(ShopDto shopDto) throws ResponseStatusException;
}
