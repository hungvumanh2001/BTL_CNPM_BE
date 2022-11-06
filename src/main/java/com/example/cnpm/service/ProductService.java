package com.example.cnpm.service;

import com.example.cnpm.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    Page<Product> findAll(Pageable pageable);
    Page<Product> findAllByTitleContains(Pageable pageable, String key);

    void save(Product product);
    Page<Product> findAllByCategoryId(Pageable pageable,Long id);
    Page<Product> findAllByPriceBetween(Pageable pageable,float from,float to);
    Iterable<Product> findAllBySaleBetween(Pageable pageable, float from,float to);

    Product findById(Long id);

    Page<Product> findAllProductOrderByPriceDesc(Pageable pageable);

    Page<Product> findAllProductOrderByPriceAsc(Pageable pageable);

    Page<Product> findAllProductOrderByName(Pageable pageable);

}
