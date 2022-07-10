package com.example.shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class BuyerDto {
    String login;
    String name;
    String address;
    Double balance;
}
