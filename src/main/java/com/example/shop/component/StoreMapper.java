package com.example.shop.component;

import com.example.shop.model.StoreDto;
import com.example.shop.repository.model.StoreEntity;
import org.springframework.stereotype.Component;

@Component
public class StoreMapper {

    public StoreDto mapToStoreDto(StoreEntity storeEntity){
        return new StoreDto(storeEntity.getStore(), storeEntity.getAddress());
    }

    public StoreEntity mapToStoreEntity(StoreDto storeDto){
        return new StoreEntity(storeDto.getStore(), storeDto.getAddress());
    }
}
