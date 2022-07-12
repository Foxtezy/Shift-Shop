package com.example.shop.service;

import com.example.shop.model.BuyDto;
import com.example.shop.model.OrderInDto;
import com.example.shop.model.OrderOutDto;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public interface OrderService {
    List<OrderOutDto> getOrders(String email) throws ResponseStatusException;
    void saveOrderEntity(OrderInDto orderInDto);
    void buyWare(BuyDto buyDto) throws ResponseStatusException;
    List<OrderOutDto> getNotShippedWares(String store) throws ResponseStatusException;
    void updateOrderStatus(Long orderId, String orderStatus) throws ResponseStatusException;
}
