package com.example.shop.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class StoreByWareDto {
    @Schema(example = "babka", required = true)
    String store;
    @Schema(example = "Tsvetnoy passage", required = true)
    String address;
    @Schema(example = "10", required = true)
    Integer amount;
}
