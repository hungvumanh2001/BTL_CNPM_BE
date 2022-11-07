package com.example.cnpm.repository;

import com.example.cnpm.model.Category;
import com.example.cnpm.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Locale;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("select u from Category u  where u.id = ?1")
    Category findById(Long id);
}
