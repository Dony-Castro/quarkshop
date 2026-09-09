package com.dony.quarkshop.product;

import com.dony.quarkshop.product.dto.CreateProductRequest;
import com.dony.quarkshop.product.dto.ProductResponse;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {
    private final ProductService service;

    public ProductResource(ProductService service) {
        this.service = service;
    }

    @GET
    public List<ProductResponse> getAll() {
        return service.findAll();
    }

    @POST
    public Response create(@Valid CreateProductRequest request) {

        ProductResponse product = service.create(request);

        return Response
                .created(URI.create("/product/" + product.id()))
                .entity(product)
                .build();
    }
}
