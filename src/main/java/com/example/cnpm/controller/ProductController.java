package com.example.cnpm.controller;


import com.example.cnpm.model.Product;
import com.example.cnpm.repository.ProductRepository;
import com.example.cnpm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;
    @GetMapping
    public ResponseEntity<Iterable<Product>> findAll(@PageableDefault(size =12) Pageable pageable)
    {
        Iterable<Product> products=productService.findAll(pageable);
        if(products==null)
            return new ResponseEntity<>(products, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/search-by-cateId")
    public ResponseEntity<Iterable<Product>> findAllByCateId(@PageableDefault(size =12)Pageable pageable,@RequestParam int id) {
        Iterable<Product> products=productService.findAllByCategoryId(pageable,id);
        if(products==null)
            return new ResponseEntity<>(products, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    //tìm kiếm theo khoảng giá
    @GetMapping("/price-between")
    public ResponseEntity<Iterable<Product>>findAllByPriceBetween(@RequestParam float from,@RequestParam float to)
    {
        Iterable<Product> products=productService.findAllByPriceBetween(from,to);
        if(products==null)
            return new ResponseEntity<>(products, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @RequestMapping(value = "/{productId}", method = RequestMethod.DELETE)
    public Product removeHoSok(@PathVariable("productId") String productId) {
        Product pr = productService.remove(new Long(productId));
        return pr;
    }
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Product product) {
        Optional<Product> oldAnswer = Optional.ofNullable(productRepository.findById(id));
        if (!oldAnswer.isPresent()) {
            return new ResponseEntity(HttpStatus.OK);
        }
        product.setId(id);
        productRepository.save(product);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity save(@RequestBody Product product) {
        return new ResponseEntity(productRepository.save(product), HttpStatus.OK);
    }

}