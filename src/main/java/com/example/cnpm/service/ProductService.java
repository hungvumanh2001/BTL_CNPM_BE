package com.example.cnpm.service;

import com.example.cnpm.model.Product;

import java.util.Optional;

public interface ProductService {
    Optional<Product>findById(Long id);
}
