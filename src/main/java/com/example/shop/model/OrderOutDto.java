package com.example.shop.model;

import com.example.shop.repository._enum_.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class OrderOutDto {
    Long orderId;
    String ware;
    Double price;
    Integer amount;
    OrderStatus orderStatus;
}
