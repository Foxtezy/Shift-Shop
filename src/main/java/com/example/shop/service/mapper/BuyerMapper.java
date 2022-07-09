package com.example.shop.service.mapper;

import com.example.shop.repository.model.BuyerEntity;
import com.example.shop.service.dto.BuyerDto;
import org.jetbrains.annotations.NotNull;

public class BuyerMapper {
    public static BuyerDto mapToBuyerDto(@NotNull BuyerEntity buyerEntity){
        BuyerDto buyerDto = new BuyerDto();
        buyerDto.setLogin(buyerEntity.getLogin());
        buyerDto.setAddress(buyerEntity.getAddress());
        buyerDto.setBalance(buyerEntity.getBalance());
        return buyerDto;
    }
    public static BuyerEntity mapToBuyerEntity(@NotNull BuyerDto buyerDto){
        BuyerEntity buyerEntity = new BuyerEntity();
        buyerEntity.setLogin(buyerDto.getLogin());
        buyerEntity.setAddress(buyerEntity.getAddress());
        buyerEntity.setBalance(buyerEntity.getBalance());
        return buyerEntity;
    }
}
