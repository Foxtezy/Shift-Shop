package com.example.shop.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import javax.validation.constraints.Positive;


@Data @AllArgsConstructor
public class BuyDto {

    @Schema(example = "nmahov2003@gmail.com", required = true)
    String email;

    @Schema(example = "shawarma", required = true)
    String ware;

    @Schema(example = "babka", required = true)
    String store;

    @Positive
    @Schema(example = "3", required = true)
    Integer amount;
}
