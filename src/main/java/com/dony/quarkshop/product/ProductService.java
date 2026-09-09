package com.dony.quarkshop.product;

import com.dony.quarkshop.product.dto.CreateProductRequest;
import com.dony.quarkshop.product.dto.ProductResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ProductResponse create(CreateProductRequest request){

        Product product = new Product();

        product.name = request.name();
        product.description = request.description();
        product.price = request.price();
        product.stock = request.stock();

        repository.persist(product);

        return toResponse(product);
    }

    public List<ProductResponse> findAll() {
        return repository
                .listAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private ProductResponse toResponse(Product product) {
        return new ProductResponse(
                product.id,
                product.name,
                product.description,
                product.price,
                product.stock
        );
    }
}
