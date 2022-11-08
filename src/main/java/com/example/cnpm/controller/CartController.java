package com.example.cnpm.controller;

import com.example.cnpm.model.Cart;
import com.example.cnpm.repository.CartRepository;
import com.example.cnpm.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.logging.Logger;

@Controller
@CrossOrigin("*")
@RequestMapping("/carts")
public class CartController {
    private static Logger logger = Logger.getLogger(String.valueOf(CartController.class));
    @Autowired
    private CartService cartService;
    @Autowired
    private CartRepository cartRepository;

    @GetMapping("/search-by-cartId/{cartId}")
    public ResponseEntity<Cart> findByCartId(@PathVariable Long cartId) {
        return new ResponseEntity(cartService.findById(cartId), HttpStatus.OK);
    }

    @GetMapping("/search-by-userId/{userId}")
    public ResponseEntity<Iterable<Cart>> findAllByUserId(@PathVariable Long userId) {
        return new ResponseEntity(cartRepository.findAllByUserId(userId), HttpStatus.OK);
    }

    @PostMapping("/add-cart")
    public ResponseEntity findAllByStatus(@RequestBody Cart cart) {
        try
        {
            cartService.save(cart);
            return new ResponseEntity(cart, HttpStatus.OK);
        }catch (Exception e)
        {
            throw new NullPointerException("error find cart by status");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCart(@PathVariable Long id) {
        boolean check = cartRepository.existsById(id);//kiểm tra xem id này có không
        if (check) {
            cartService.deleteCart(id);
            logger.info("delete cart by id");
            return new ResponseEntity(HttpStatus.OK);
        } else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update-cart/{id}")
    public ResponseEntity updateCart(@PathVariable Long id, @RequestBody Cart cart) {
        Optional<Cart> oldCart = cartRepository.findById(id);
        if (!oldCart.isPresent()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        cart.setId(id);
        cartRepository.save(cart);
        return new ResponseEntity(HttpStatus.OK);
    }
}
