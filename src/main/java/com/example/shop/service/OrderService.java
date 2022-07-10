package com.example.shop.service;

import com.example.shop.model.OrderInDto;
import com.example.shop.model.OrderOutDto;

import java.util.List;

public interface OrderService {
    List<OrderOutDto> getOrders(String email);
    OrderOutDto saveOrderEntity(OrderInDto orderInDto);
}
