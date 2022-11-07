package com.example.cnpm.service;

import com.example.cnpm.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<Product> findAll(Pageable pageable);
    void save(Product product);
    Page<Product> findAllByCategoryId(Pageable pageable, int id);
    Iterable<Product>findAllByPriceBetween(float from,float to);

    Product remove(Long id);


//    Product createOrUpdate(Product product);

}