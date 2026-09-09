package com.dony.quarkshop.product.application.create;

import com.dony.quarkshop.product.domain.Product;
import com.dony.quarkshop.product.domain.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CreateProductUseCase {
    private final ProductRepository repository;

    public CreateProductUseCase( ProductRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Product execute(CreateProductCommand command) {
        Product product = new Product(
                command.name(),
                command.description(),
                command.price(),
                command.stock()
        );

        repository.save(product);

        return product;
    }
}
