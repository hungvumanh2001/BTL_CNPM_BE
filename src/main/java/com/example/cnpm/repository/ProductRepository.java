package com.example.cnpm.repository;

import com.example.cnpm.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAll(Pageable pageable);
    Page<Product> findAllByTitleContains(Pageable pageable , String key);
    Page<Product> findAllByCategoryId(Pageable pageable,Long id);

    Page<Product> findAllBySaleBetween(Pageable pageable, float from,float to);

    Page<Product> findAllByPriceBetween(Pageable pageable, float from, float to);
    Optional<Product> findById(Long id);

    @Query("select u from Product u order by u.price desc ")
    Page<Product> findAllProductOrderByPriceDesc(Pageable pageable);

    @Query("select u from Product u order by u.price asc ")
    Page<Product> findAllProductOrderByPriceAsc(Pageable pageable);

    @Query("select u from Product u order by u.title desc ")
    Page<Product> findAllProductOrderByName(Pageable pageable);
}
