package com.dony.quarkshop.product.presentation.rest.dto;

import com.dony.quarkshop.product.domain.Product;

import java.math.BigDecimal;

public record ProductResponse(
        Long id,
        String name,
        String description,
        BigDecimal price,
        Integer stock
) {
    public static ProductResponse from(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock()
        );
    }
}
