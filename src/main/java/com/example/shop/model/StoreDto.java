package com.example.shop.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data @AllArgsConstructor
public class StoreDto {
    @Schema(example = "babka", required = true)
    String store;
    @Schema(example = "Tsvetnoy passage", required = true)
    String address;
}
