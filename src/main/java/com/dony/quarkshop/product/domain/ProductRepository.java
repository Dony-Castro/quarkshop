package com.dony.quarkshop.product.domain;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    void save(Product product);
    Optional<Product> findOptionalById(Long id);
    List<Product> findAllProducts();
}
