package com.example.shop;


import com.example.shop.model.ShopDto;
import com.example.shop.repository.BuyerRepository;
import com.example.shop.repository.ProductRepository;
import com.example.shop.repository.ShopRepository;
import com.example.shop.repository.StoreRepository;
import com.example.shop.repository.model.ShopEntity;
import com.example.shop.service.ShopService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;


@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class AddWareToStoreTests {


    private final ShopService shopService;

    @Autowired
    public AddWareToStoreTests(ShopService shopService) {
        this.shopService = shopService;
    }

    @MockBean
    private ProductRepository productRepository;
    @MockBean
    private StoreRepository storeRepository;
    @MockBean
    private ShopRepository shopRepository;


    @Test
    public void addNewWareToStore() {
        Mockito.when(productRepository.existsById("shawarma")).thenReturn(true);
        Mockito.when(storeRepository.existsById("babka")).thenReturn(true);
        ShopDto shopDto = new ShopDto("shawarma", "babka", 3);
        Mockito.when(shopRepository.getShopEntityByWareAndStore(shopDto.getWare(), shopDto.getStore())).thenReturn(Optional.empty());
        Assertions.assertEquals(shopService.addWareToStore(shopDto),
                ResponseEntity.status(HttpStatus.CREATED).body("Create new position in '" + shopDto.getStore() + "' store"));
    }

    @Test
    public void addOldWareToStore(){
        Mockito.when(productRepository.existsById("shawarma")).thenReturn(true);
        Mockito.when(storeRepository.existsById("babka")).thenReturn(true);
        ShopDto shopDto = new ShopDto("shawarma", "babka", 3);
        Mockito.when(shopRepository.getShopEntityByWareAndStore(shopDto.getWare(), shopDto.getStore())).thenReturn(Optional.of(new ShopEntity("shawarma", 5, "babka")));
        Assertions.assertEquals(shopService.addWareToStore(shopDto),
                ResponseEntity.ok("Add wares in '" + shopDto.getStore() + "' store\n Now " + (5 + 3) + " wares"));
    }

}
