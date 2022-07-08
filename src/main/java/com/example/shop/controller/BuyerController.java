package com.example.shop.controller;


import com.example.shop.repository.model.BuyerEntity;
import com.example.shop.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
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
    public ResponseEntity<Object> getByLogin(@RequestParam String login) {
        try {
            return ResponseEntity.ok(buyerService.findBylogin(login));
        }
        catch (HttpClientErrorException e){
            return ResponseEntity.status(e.getStatusCode()).body(e.toString());
        }
    }

    @PostMapping
    public ResponseEntity<Object> saveBuyerEntity(@RequestBody BuyerEntity buyerEntity) {
        try {
            return ResponseEntity.ok(buyerService.saveBuyerEntity(buyerEntity));
        }
        catch (HttpClientErrorException e){
            return ResponseEntity.status(e.getStatusCode()).body(e.toString());
        }
    }

    @PutMapping
    public ResponseEntity<Object> putBuyerEntity(@RequestBody BuyerEntity buyerEntity){
        try {
            return ResponseEntity.ok(buyerService.putBuyerEntity(buyerEntity));
        }
        catch (HttpClientErrorException e){
            return ResponseEntity.status(e.getStatusCode()).body(e.toString());
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteBuyerEntity(@RequestParam String login) {
        try {
            buyerService.deleteBuyerEntity(login);
            return ResponseEntity.ok("OK");
        }
        catch (HttpClientErrorException e){
            return ResponseEntity.status(e.getStatusCode()).body(e.toString());
        }
    }

    @GetMapping("/all")
    public List<BuyerEntity> getAllBuyerEntity(){
        return buyerService.getAllBuyerEntity();
    }

}
