package com.example.shop.service.impl;

import com.example.shop.repository.BuyerRepository;
import com.example.shop.repository.model.BuyerEntity;
import com.example.shop.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Service
public class BuyerServiceImpl implements BuyerService {
    private final BuyerRepository buyerRepository;

    @Autowired
    public BuyerServiceImpl(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    public ResponseEntity<BuyerEntity> findBylogin(String login) {
        Optional<BuyerEntity> optionalBuyerEntity = buyerRepository.findById(login);
        if (optionalBuyerEntity.isPresent()){
            BuyerEntity buyerEntity = optionalBuyerEntity.get();
            return ResponseEntity.ok(buyerEntity);
        }
        else {
            return ResponseEntity.of(optionalBuyerEntity);
        }
    }

    public ResponseEntity<Object> saveBuyerEntity(BuyerEntity buyerEntity){
        if (buyerRepository.existsById(buyerEntity.getLogin())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(buyerRepository.save(buyerEntity));
    }

    public ResponseEntity<Object> putBuyerEntity(BuyerEntity buyerEntity){ //переделать
        if (buyerRepository.existsById(buyerEntity.getLogin())){
            buyerRepository.deleteById(buyerEntity.getLogin());
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(buyerRepository.save(buyerEntity));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
    }

    public ResponseEntity<String> deleteBuyerEntity(String login){
        if (buyerRepository.existsById(login)) {
            buyerRepository.deleteById(login);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("OK (CODE 200)\n");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("(CODE 400)\n");
    }

    public List<BuyerEntity> getAllBuyerEntity(){
        return (List<BuyerEntity>)buyerRepository.findAll();
    }

    public ResponseEntity<Object> reduceBuyerEntityBalance(Double reduce, String login) throws ArithmeticException, HttpClientErrorException {
        if (buyerRepository.existsById(login)){
            double oldBalance = buyerRepository.findById(login).get().getBalance();
            if (oldBalance >= reduce) {
                BuyerEntity buyerEntity = new BuyerEntity(login,buyerRepository.findById(login).get().getAddress(),oldBalance-reduce);
                return ResponseEntity.ok(buyerRepository.save(buyerEntity));
            }
            else throw new ArithmeticException();
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
    }
}
