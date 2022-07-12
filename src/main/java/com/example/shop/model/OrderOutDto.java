package com.example.shop.model;

import com.example.shop.repository._enum_.OrderStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class OrderOutDto {

    @Schema(example = "21216", required = true)
    Long orderId;

    @Schema(example = "shawarma", required = true)
    String ware;

    @Schema(example = "145.5", required = true)
    Double price;

    @Schema(example = "3", required = true)
    Integer amount;

    @Schema(example = "DELIVER", required = true)
    OrderStatus orderStatus;

    @Schema(example = "babka", required = true)
    String store;
}
