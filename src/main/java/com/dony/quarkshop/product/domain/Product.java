package com.dony.quarkshop.product.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(length = 2000)
    private String description;

    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer stock;

    protected Product() {
    }

    public Product(
            String name,
            String description,
            BigDecimal price,
            Integer stock
    )
    {
        validateName(name);
        validatePrice(price);
        validateStock(stock);

        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "Product name is required"
            );
        }
    }

    private void validatePrice(BigDecimal price) {
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(
                    "Product price must be greater than zero"
            );
        }
    }

    private void validateStock(Integer stock) {
        if (stock == null || stock < 0) {
            throw new IllegalArgumentException(
                    "Product stock cannot be negative"
            );
        }
    }
}
