package com.dony.quarkshop.product.application.create;

import java.math.BigDecimal;

public record CreateProductCommand(
        String name,
        String description,
        BigDecimal price,
        Integer stock
) {
}
