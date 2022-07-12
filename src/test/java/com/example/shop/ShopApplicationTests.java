package com.example.shop;


import com.example.shop.repository.ProductRepository;
import com.example.shop.repository.ShopRepository;
import com.example.shop.repository.StoreRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.anyString;

@SpringBootTest
class ShopApplicationTests {


    @Test
    void contextLoads() {
        ProductRepository productRepository = Mockito.mock(ProductRepository.class);
        Mockito.when(productRepository.existsById(anyString())).thenReturn(Boolean.TRUE);
        StoreRepository storeRepository = Mockito.mock(StoreRepository.class);
        Mockito.when(storeRepository.existsById(anyString())).thenReturn(Boolean.TRUE);

        ShopRepository shopRepository = Mockito.mock(ShopRepository.class);

    }

}
