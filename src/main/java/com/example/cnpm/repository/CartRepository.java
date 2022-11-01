package com.example.cnpm.repository;

import com.example.cnpm.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Iterable<Cart>findAllByUserId(Long id);

    Iterable<Cart>findAllByUserIdAndStatus(Long id,int status);
}
