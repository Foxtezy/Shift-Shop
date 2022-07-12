package com.example.shop.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data @AllArgsConstructor
public class ShopDto {
    @Schema(example = "shawarma", required = true)
    String ware;
    @Schema(example = "babka", required = true)
    String store;
    @Schema(example = "10", required = true)
    Integer amount;
}
