package com.dony.quarkshop.product.presentation.rest;

import com.dony.quarkshop.product.application.create.CreateProductCommand;
import com.dony.quarkshop.product.application.create.CreateProductUseCase;
import com.dony.quarkshop.product.application.get.GetProductByIdUseCase;
import com.dony.quarkshop.product.application.list.ListProductsUseCase;

import com.dony.quarkshop.product.domain.Product;

import com.dony.quarkshop.product.presentation.rest.dto.CreateProductRequest;
import com.dony.quarkshop.product.presentation.rest.dto.ProductResponse;

import jakarta.validation.Valid;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;

@Path("/api/v1/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    private final CreateProductUseCase createProduct;
    private final ListProductsUseCase listProducts;
    private final GetProductByIdUseCase getProductById;

    public ProductResource(
            CreateProductUseCase createProduct,
            ListProductsUseCase listProducts,
            GetProductByIdUseCase getProductById
    ) {
        this.createProduct = createProduct;
        this.listProducts = listProducts;
        this.getProductById = getProductById;
    }

    @POST
    public Response create(
            @Valid CreateProductRequest request
    ) {

        CreateProductCommand command =
                new CreateProductCommand(
                        request.name(),
                        request.description(),
                        request.price(),
                        request.stock()
                );

        Product product =
                createProduct.execute(command);

        ProductResponse response =
                ProductResponse.from(product);

        return Response
                .created(
                        URI.create(
                                "/api/v1/products/"
                                        + product.getId()
                        )
                )
                .entity(response)
                .build();
    }

    @GET
    public List<ProductResponse> list() {

        return listProducts
                .execute()
                .stream()
                .map(ProductResponse::from)
                .toList();
    }

    @GET
    @Path("/{id}")
    public ProductResponse getById(
            @PathParam("id") Long id
    ) {

        Product product =
                getProductById.execute(id);

        return ProductResponse.from(product);
    }
}