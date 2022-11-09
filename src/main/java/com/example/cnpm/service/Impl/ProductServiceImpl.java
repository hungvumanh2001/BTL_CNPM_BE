package com.example.cnpm.service.Impl;

import com.example.cnpm.model.Product;
import com.example.cnpm.repository.ProductRepository;
import com.example.cnpm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;

    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }
}
