package com.dony.quarkshop.product.infrastructure.persistence;

import com.dony.quarkshop.product.domain.Product;
import com.dony.quarkshop.product.domain.ProductRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class PanacheProductRepository implements ProductRepository, PanacheRepository<Product> {

    @Override
    public void save(Product product) {
        persist(product);
    }

    @Override
    public Optional<Product> findOptionalById(Long id) {
        return findByIdOptional(id);
    }

    @Override
    public List<Product> findAllProducts() {
        return listAll();
    }
}
