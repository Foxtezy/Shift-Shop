package com.example.shop.component;


import com.example.shop.model.OrderOutDto;
import com.example.shop.repository.model.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderOutMapper {

    public OrderOutDto mapToOrderOutDto(OrderEntity orderEntity){
        return new OrderOutDto(orderEntity.getOrderId(),
                            orderEntity.getWare(),
                            orderEntity.getPrice(),
                            orderEntity.getAmount(),
                            orderEntity.getOrderStatus(),
                            orderEntity.getStore());
    }


}
