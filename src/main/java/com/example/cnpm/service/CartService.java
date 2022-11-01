package com.example.cnpm.service;

import com.example.cnpm.model.Cart;
import jdk.nashorn.internal.runtime.options.Option;

import java.util.Optional;

public interface CartService {
    Iterable<Cart>findAllByUserIdAndStatus(Long id, int status);

    void save(Cart cart);

    Optional<Cart> findById(Long id);
}
