package com.exampleas.shoppingapp.products;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductModel, Integer> {
    List<ProductModel> findByNameLike(String name);
}
