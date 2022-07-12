package com.example.shop.controller;


import com.example.shop.model.ShopDto;
import com.example.shop.service.ShopService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("shop")
public class ShopController {

    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping
    @Operation(summary = "Add or remove wares from the store", tags = "Store")
        @ApiResponse(responseCode = "200", description = "The wares was successfully add (remove)")
        @ApiResponse(responseCode = "201", description = "New ware was successfully add")
        @ApiResponse(responseCode = "400", description = "There are not enough wares in store", content = @Content)
        @ApiResponse(responseCode = "404", description = "This ware or store wasn't found", content = @Content)
    public ResponseEntity<String> addWareToStore(ShopDto shopDto){
        return shopService.addWareToStore(shopDto);
    }
}
