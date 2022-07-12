package com.example.shop.service;

import com.example.shop.model.BuyDto;
import com.example.shop.repository.model.BuyerEntity;
import com.example.shop.model.BuyerDto;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


public interface BuyerService {
    BuyerDto findByEmail(String login) throws ResponseStatusException;
    void saveBuyerEntity(BuyerDto buyerDto) throws ResponseStatusException;
    void putBuyerEntity(BuyerEntity buyerEntity) throws ResponseStatusException;
    void deleteBuyerEntity(String login) throws ResponseStatusException;
    List<BuyerDto> getAllBuyerEntity();
    Integer updateBalance(BuyDto buyDto, Double newBalance);
}
