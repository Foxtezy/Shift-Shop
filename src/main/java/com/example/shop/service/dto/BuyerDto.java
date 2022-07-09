package com.example.shop.service.dto;

import lombok.Data;

@Data
public class BuyerDto {
    String login;
    String address;
    Double balance;
}
