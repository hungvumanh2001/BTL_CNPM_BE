package com.example.cnpm.service.impl;

import com.example.cnpm.model.Cart;
import com.example.cnpm.repository.CartRepository;
import com.example.cnpm.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Override
    public void save(Cart cart) {
        cartRepository.save(cart);
    }


    @Override
    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }

    @Override
    public Optional<Cart> findById(Long id) {
        return cartRepository.findById(id);
    }

    @Override
    public Iterable<Cart> findAllByUserId(Long id) {
        return cartRepository.findAllByUserId(id);
    }

}
