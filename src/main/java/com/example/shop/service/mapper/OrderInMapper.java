package com.example.shop.service.mapper;

import com.example.shop.model.OrderInDto;
import com.example.shop.repository.model.OrderEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderInMapper {
    public OrderEntity mapToOrderEntity(OrderInDto orderInDto){
        return new OrderEntity(orderInDto.getWare(),
                orderInDto.getPrice(),
                orderInDto.getAmount(),
                orderInDto.getOrderStatus(),
                orderInDto.getBuyerEmail());
    }
}
