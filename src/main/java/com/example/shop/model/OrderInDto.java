package com.example.shop.model;

import com.example.shop.repository._enum_.OrderStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
public class OrderInDto {

    @Schema(example = "shawarma", required = true)
    String ware;

    @Positive
    @Schema(example = "145.5", required = true)
    Double price;

    @Positive
    @Schema(example = "145.5", required = true)
    Integer amount;

    @Schema(example = "DELIVER", required = true)
    OrderStatus orderStatus;

    @Schema(example = "nmahov2003@gmail.com", required = true)
    String buyerEmail;

    @Schema(example = "babka", required = true)
    String store;
}
