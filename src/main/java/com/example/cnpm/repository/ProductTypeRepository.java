package com.example.cnpm.repository;

import com.example.cnpm.model.Category;
import com.example.cnpm.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Integer> {
    @Query("select u from ProductType u  where u.id = ?1")
    ProductType findById(Long id);
}
