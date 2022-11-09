package com.example.cnpm.service;

import com.example.cnpm.model.Cart;

import java.util.Optional;

public interface CartService {
    void save(Cart cart);
    void deleteCart(Long id);
    Optional<Cart> findById(Long id);
    Iterable<Cart> findAllByUserId(Long id);
}
