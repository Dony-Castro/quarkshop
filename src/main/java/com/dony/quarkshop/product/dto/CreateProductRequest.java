package com.dony.quarkshop.product.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record CreateProductRequest(
        @NotBlank
        String name,

        String description,

        @DecimalMin("0.01")
        BigDecimal price,

        @Min(0)
        Integer stock
) {
}
