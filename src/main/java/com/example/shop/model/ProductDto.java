package com.example.shop.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;

@Data @AllArgsConstructor
public class ProductDto {
    @Schema(example = "shawarma", required = true)
    String ware;
    @Schema(example = "140.5", required = true)
    Double price;
    @Schema(example = "The best shawarma from the babka", required = false)
    String description;
}
