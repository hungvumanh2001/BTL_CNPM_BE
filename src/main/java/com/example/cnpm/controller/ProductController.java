package com.example.cnpm.controller;

import com.example.cnpm.model.Product;
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
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Iterable<Product>> findAll(@PageableDefault(size = 3) Pageable page) {
        Iterable<Product> products = productService.findAll(page);
        if (products == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/find-all-in-search-result")
    public ResponseEntity<Iterable<Product>> findAllInSearchResult(@PageableDefault(size = 9) Pageable page) {
        Iterable<Product> products = productService.findAll(page);
        if (products == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/find-all-by-name")
    public ResponseEntity<Iterable<Product>> findAllByName(@PageableDefault(size = 9) Pageable page, @RequestParam String key) {
        Iterable<Product> products = productService.findAllByTitleContains(page, key);
        if (products == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/search-by-cateId")
    public ResponseEntity<Iterable<Product>> findAllByCateId(@PageableDefault(size = 3) Pageable page, @RequestParam Long id) {
        Iterable<Product> products = productService.findAllByCategoryId(page, id);
        if (products == null)
            return new ResponseEntity<>(products, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/price-between")
    public ResponseEntity<Iterable<Product>> findAllByPriceBetween(@PageableDefault(size = 9) Pageable page,@RequestParam float from, @RequestParam float to) {
        Iterable<Product> products = productService.findAllByPriceBetween(page, from, to);
        if (products == null)
            return new ResponseEntity<>(products, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/sale-between")
    public ResponseEntity<Iterable<Product>> findAllBySaleBetween(@PageableDefault(size = 4) Pageable page, @RequestParam float from, @RequestParam float to) {
        Iterable<Product> products = productService.findAllBySaleBetween(page, from, to);
        if (products == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> findById(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        if (!product.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/find-product-desc")
    public ResponseEntity<Iterable<Product>> findAllProductOrderByPriceDesc(@PageableDefault(size = 9) Pageable page) {
        Iterable<Product> products = productService.findAllProductOrderByPriceDesc(page);
        if (products == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/find-product-asc")
    public ResponseEntity<Iterable<Product>> findAllProductOrderByPriceAsc(@PageableDefault(size = 9) Pageable page) {
        Iterable<Product> products = productService.findAllProductOrderByPriceAsc(page);
        if (products == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/sort-product-by-name")
    public ResponseEntity<Iterable<Product>> findAllProductOrderByName(@PageableDefault(size = 9) Pageable page) {
        Iterable<Product> products = productService.findAllProductOrderByName(page);
        if (products == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @RequestMapping(value = "/{productId}", method = RequestMethod.DELETE)
    public Product removeHoSok(@PathVariable("productId") String productId) {
        Product pr = productService.remove(new Long(productId));
        return pr;
    }
}
