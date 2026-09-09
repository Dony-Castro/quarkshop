package com.dony.quarkshop.product.presentation.rest.error;

public record ApiError(
        String type,
        String title,
        int status,
        String detail,
        String instance
) {
}
