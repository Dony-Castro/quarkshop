package com.dony.quarkshop.product.application.list;

import com.dony.quarkshop.product.domain.Product;
import com.dony.quarkshop.product.domain.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ListProductsUseCase {
    private final ProductRepository repository;

    public ListProductsUseCase(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> execute() {
        return repository.findAllProducts();
    }
}
