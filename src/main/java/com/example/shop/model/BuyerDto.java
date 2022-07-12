package com.example.shop.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data @AllArgsConstructor @NoArgsConstructor
public class BuyerDto {

    @Schema(example = "nmahov2003@gmail.com", required = true)
    String login;

    @Schema(example = "Mikola", required = true)
    String name;

    @Schema(example = "Pirogova 18", required = true)
    String address;

    @PositiveOrZero
    @Schema(example = "200.5", required = true)
    Double balance;
}
