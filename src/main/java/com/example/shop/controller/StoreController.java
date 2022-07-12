package com.example.shop.controller;


import com.example.shop.model.StoreDto;
import com.example.shop.service.StoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("store")
public class StoreController {

    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping
    @Operation(summary = "Add new store or edit store address", tags = "Store")
        @ApiResponse(responseCode = "200", description = "The store address was edit")
        @ApiResponse(responseCode = "201", description = "The store was add")
    public ResponseEntity<String> postStore(StoreDto storeDto){
        return storeService.saveNewStore(storeDto);
    }

    @GetMapping
    @Operation(summary = "Get all stores", tags = "Store")
        @ApiResponse(responseCode = "200", description = "The stores was successfully received")
    public List<StoreDto> getAllStores(){
        return storeService.getAllStores();
    }
}
