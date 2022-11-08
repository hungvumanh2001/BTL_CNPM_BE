package com.example.cnpm.service.Impl;

import com.example.cnpm.model.Product;
import com.example.cnpm.repository.ProductRepository;
import com.example.cnpm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public Page<Product> findAll(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Page<Product> findAllByTitleContains(Pageable pageable, String key) {
        return repository.findAllByTitleContains(pageable, key);
    }

    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Override
    public Page<Product> findAllByCategoryId(Pageable page, Long id) {
        return repository.findAllByCategoryId(page,id);
    }

    @Override
    public Page<Product> findAllByPriceBetween(Pageable pageable, float from, float to) {
        return repository.findAllByPriceBetween(pageable,from,to);
    }

    @Override
    public Iterable<Product> findAllBySaleBetween(Pageable pageable, float from, float to) {
        return repository.findAllBySaleBetween(pageable, from, to);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Page<Product> findAllProductOrderByPriceDesc(Pageable page) {
        return repository.findAllProductOrderByPriceDesc(page);
    }

    @Override
    public Page<Product> findAllProductOrderByPriceAsc(Pageable page) {
        return repository.findAllProductOrderByPriceAsc(page);
    }

    @Override
    public Page<Product> findAllProductOrderByName(Pageable page) {
        return repository.findAllProductOrderByName(page);
    }
}
