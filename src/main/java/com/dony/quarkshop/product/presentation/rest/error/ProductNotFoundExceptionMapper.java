package com.dony.quarkshop.product.presentation.rest.error;

import com.dony.quarkshop.product.domain.ProductNotFoundException;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ProductNotFoundExceptionMapper implements ExceptionMapper<ProductNotFoundException> {

    @Context
    UriInfo uriInfo;

    @Override
    public Response toResponse(
            ProductNotFoundException exception
    ) {
        ApiError error = new ApiError(
                "PRODUCT_NOT_FOUND",
                "Product not found",
                Response.Status.NOT_FOUND.getStatusCode(),
                exception.getMessage(),
                uriInfo.getPath()
        );

        return Response.status(Response.Status.NOT_FOUND)
                .entity(error)
                .build();
    }
}
