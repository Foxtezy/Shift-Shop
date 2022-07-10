package com.example.shop.model;

import com.example.shop.repository._enum_.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderInDto {
    String ware;
    Double price;
    Integer amount;
    OrderStatus orderStatus;
    String buyerEmail;
}
