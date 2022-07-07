package com.example.shop.controller;


import com.example.shop.repository.model.BuyerEntity;
import com.example.shop.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("buyer")
public class BuyerController {
    private final BuyerService buyerService;

    @Autowired
    public BuyerController(BuyerService buyerService){
        this.buyerService = buyerService;
    }

    @GetMapping
    public ResponseEntity<BuyerEntity> getByLogin(@RequestParam String login) {
        return buyerService.findBylogin(login);
    }

    @PostMapping
    public ResponseEntity<BuyerEntity> saveBuyerEntity(@RequestBody BuyerEntity buyerEntity) {
        return buyerService.saveBuyerEntity(buyerEntity);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteBuyerEntity(@RequestParam String login) {
        return buyerService.deleteBuyerEntity(login);
    }

    @GetMapping("/all")
    public List<BuyerEntity> getAllBuyerEntity(){
        return buyerService.getAllBuyerEntity();
    }
}
