package com.example.shop.service.impl;

import com.example.shop.repository.BuyerRepository;
import com.example.shop.repository.model.BuyerEntity;
import com.example.shop.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class BuyerServiceImpl implements BuyerService {
    private final BuyerRepository buyerRepository;

    @Autowired
    public BuyerServiceImpl(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    public ResponseEntity<BuyerEntity> findBylogin(String login) {
        Optional<BuyerEntity> optionalBuyerEntity = buyerRepository.findBylogin(login);
        if (optionalBuyerEntity.isPresent()){
            BuyerEntity buyerEntity = optionalBuyerEntity.get();
            return ResponseEntity.ok(buyerEntity);
        }
        else {
            return ResponseEntity.of(optionalBuyerEntity);
        }
    }

    public ResponseEntity<BuyerEntity> saveBuyerEntity(BuyerEntity buyerEntity){
        if (buyerRepository.existsById(buyerEntity.getLogin())){
            buyerRepository.deleteById(buyerEntity.getLogin());
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(buyerRepository.save(buyerEntity));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(buyerRepository.save(buyerEntity));
    }

    public ResponseEntity<String> deleteBuyerEntity(String login){
        if (buyerRepository.existsById(login)) {
            buyerRepository.deleteById(login);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("OK (CODE 200)\n");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("(CODE 400)\n");
    }
}
