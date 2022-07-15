package com.example.shop;


import com.example.shop.model.BuyDto;
import com.example.shop.repository.BuyerRepository;
import com.example.shop.repository.OrderRepository;
import com.example.shop.repository.ProductRepository;
import com.example.shop.repository.model.BuyerEntity;
import com.example.shop.repository.model.ProductEntity;
import com.example.shop.service.OrderService;
import com.example.shop.service.ShopService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class BuyWareTests {
    private final OrderService orderService;
    @Autowired
    public BuyWareTests(OrderService orderService) {
        this.orderService = orderService;
    }
    @MockBean
    private ProductRepository productRepository;
    @MockBean
    private BuyerRepository buyerRepository;
    @MockBean
    private ShopService shopService;
    @MockBean
    private OrderRepository orderRepository;


    @Test
    public void buyValidWareTest(){
        BuyDto buyDto = new BuyDto("nmahov2003@gmail.com", "shawarma", "babka", 4);
        Mockito.when(buyerRepository.findById("nmahov2003@gmail.com")).thenReturn
                (Optional.of(new BuyerEntity("nmahov2003@gmail.com", "Mikola", "Pirogova 18", 100.0)));
        Mockito.when(productRepository.findById("shawarma")).thenReturn
                (Optional.of(new ProductEntity("shawarma", 20.0, "")));
        try {
            orderService.buyWare(buyDto);
        }
        catch (ResponseStatusException e){
            Assert.fail(e.toString());
        }
    }

    @Test
    public void buyNoEnoughMoneyWareTest(){
        BuyDto buyDto = new BuyDto("nmahov2003@gmail.com", "shawarma", "babka", 8);
        Mockito.when(buyerRepository.findById("nmahov2003@gmail.com")).thenReturn
                (Optional.of(new BuyerEntity("nmahov2003@gmail.com", "Mikola", "Pirogova 18", 100.0)));
        Mockito.when(productRepository.findById("shawarma")).thenReturn
                (Optional.of(new ProductEntity("shawarma", 20.0, "")));
        try {
            orderService.buyWare(buyDto);
        }
        catch (ResponseStatusException e){
            Assert.assertEquals(e.toString(), new ResponseStatusException(HttpStatus.BAD_REQUEST, "This buyer doesn't have enough money").toString());
        }
    }
}
