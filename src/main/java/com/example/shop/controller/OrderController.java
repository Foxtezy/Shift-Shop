package com.example.shop.controller;


import com.example.shop.model.OrderInDto;
import com.example.shop.model.OrderOutDto;
import com.example.shop.service.BuyerService;
import com.example.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderOutDto> getAllOrdersByEmail(String email){
        return orderService.getOrders(email);
    }

    @PostMapping
    public OrderOutDto postOrder(OrderInDto orderInDto){
        return orderService.saveOrderEntity(orderInDto);
    }

}
