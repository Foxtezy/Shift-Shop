package com.example.shop.component;

import com.example.shop.repository.model.BuyerEntity;
import com.example.shop.model.BuyerDto;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;


@Component
public class BuyerMapper {
    public BuyerDto mapToBuyerDto(@NotNull BuyerEntity buyerEntity){
        BuyerDto buyerDto = new BuyerDto();
        buyerDto.setLogin(buyerEntity.getEmail());
        buyerDto.setAddress(buyerEntity.getAddress());
        buyerDto.setBalance(buyerEntity.getBalance());
        buyerDto.setName(buyerEntity.getName());
        return buyerDto;
    }
    public BuyerEntity mapToBuyerEntity(@NotNull BuyerDto buyerDto){
        BuyerEntity buyerEntity = new BuyerEntity();
        buyerEntity.setEmail(buyerDto.getLogin());
        buyerEntity.setAddress(buyerDto.getAddress());
        buyerEntity.setBalance(buyerDto.getBalance());
        buyerEntity.setName(buyerDto.getName());
        return buyerEntity;
    }
}
