package com.example.shop;


import com.example.shop.service.OrderService;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class BuyWareTests {
    private final OrderService orderService;

    @Autowired
    public BuyWareTests(OrderService orderService) {
        this.orderService = orderService;
    }
}
