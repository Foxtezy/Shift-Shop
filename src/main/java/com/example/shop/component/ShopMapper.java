package com.example.shop.component;


import com.example.shop.model.ShopDto;
import com.example.shop.repository.model.ShopEntity;
import org.springframework.stereotype.Component;

@Component
public class ShopMapper {

    public ShopDto mapToShopDto(ShopEntity shopEntity){
        return new ShopDto(shopEntity.getWare(), shopEntity.getStore(), shopEntity.getAmount());
    }

    public ShopEntity mapToShopEntity(ShopDto shopDto){
        return new ShopEntity(shopDto.getWare(), shopDto.getAmount(), shopDto.getStore());
    }

}
