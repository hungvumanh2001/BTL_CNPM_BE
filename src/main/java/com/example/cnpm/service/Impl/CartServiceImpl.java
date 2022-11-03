package com.example.cnpm.service.Impl;

import com.example.cnpm.model.Cart;
import com.example.cnpm.repository.CartRepository;
import com.example.cnpm.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository repository;


    @Override
    public void save(Cart cart) {
        repository.save(cart);
    }


}
