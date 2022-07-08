package com.example.shop.controller;


import com.example.shop.repository.model.BuyerEntity;
import com.example.shop.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
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
    public ResponseEntity<Object> saveBuyerEntity(@RequestBody BuyerEntity buyerEntity) {
        return buyerService.saveBuyerEntity(buyerEntity);
    }

    @PutMapping
    public ResponseEntity<Object> putBuyerEntity(@RequestBody BuyerEntity buyerEntity){
        return buyerService.putBuyerEntity(buyerEntity);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteBuyerEntity(@RequestParam String login) {
        return buyerService.deleteBuyerEntity(login);
    }

    @GetMapping("/all")
    public List<BuyerEntity> getAllBuyerEntity(){
        return buyerService.getAllBuyerEntity();
    }

    @PutMapping("/newbalance") //test
    public ResponseEntity<Object> balance(@RequestParam Double reduce, @RequestParam String login){
        return buyerService.reduceBuyerEntityBalance(reduce, login);
    }
}
