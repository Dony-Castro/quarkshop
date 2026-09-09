package com.dony.quarkshop.product.application.get;

import com.dony.quarkshop.product.domain.Product;
import com.dony.quarkshop.product.domain.ProductNotFoundException;
import com.dony.quarkshop.product.domain.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GetProductByIdUseCase {
    private final ProductRepository repository;

    public GetProductByIdUseCase(ProductRepository repository) {
        this.repository = repository;
    }

    public Product execute(Long id) {
        return repository
                .findOptionalById(id)
                .orElseThrow(
                        () -> new ProductNotFoundException(id)
                );
    }
}
