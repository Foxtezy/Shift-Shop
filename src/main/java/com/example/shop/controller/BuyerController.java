package com.example.shop.controller;


import com.example.shop.repository.model.BuyerEntity;
import com.example.shop.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("buyer")
public class BuyerController {
    private BuyerService buyerService;

    @Autowired
    public BuyerController(BuyerService buyerService){
        this.buyerService = buyerService;
    }

    @GetMapping("/get/login")
    public ResponseEntity<BuyerEntity> getByLogin(@RequestParam String login) {
        return buyerService.findBylogin(login);
    }

    @PostMapping("/post")
    public ResponseEntity<BuyerEntity> saveBuyerEntity(@RequestBody BuyerEntity buyerEntity) {
        return buyerService.saveBuyerEntity(buyerEntity);
    }

    @DeleteMapping("/dell")
    public ResponseEntity<String> deleteBuyerEntity(@RequestParam String login) {
        return buyerService.deleteBuyerEntity(login);
    }
}
