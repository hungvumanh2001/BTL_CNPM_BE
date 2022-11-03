package com.example.cnpm.controller;

import com.example.cnpm.model.Cart;
import com.example.cnpm.service.CartService;
import com.example.cnpm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService service;


    @PostMapping("/add-cart")
    public ResponseEntity findAllByStatus(@RequestBody Cart cart)
    {
        //check user hay admin ở ui
        try
        {
            service.save(cart);
            return new ResponseEntity(cart, HttpStatus.OK);
        }catch (Exception e)
        {
            throw new NullPointerException("error find cart by status");
        }

    }
}
