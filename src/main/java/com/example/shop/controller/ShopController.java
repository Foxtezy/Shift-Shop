package com.example.shop.controller;


import com.example.shop.repository.model.ShopEntity;
import com.example.shop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("shop")
public class ShopController {
    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService){
        this.shopService = shopService;
    }

    @GetMapping
    public ResponseEntity<List<ShopEntity>> getProduct(String ware){
        List<ShopEntity> products = shopService.getProduct(ware);
        if (products.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(products);
        else
            return ResponseEntity.ok(products);
    }
    @PutMapping //test
    ResponseEntity<Object> updateAmount(Integer amount, String ware, String store){
        return shopService.updateAmount(amount, ware, store);
    }
}
