package com.example.cnpm.service.Impl;

import com.example.cnpm.model.Category;
import com.example.cnpm.repository.CategoryRepository;
import com.example.cnpm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
