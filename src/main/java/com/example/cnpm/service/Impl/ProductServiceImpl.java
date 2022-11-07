package com.example.cnpm.service.Impl;

import com.example.cnpm.model.Product;
import com.example.cnpm.model.ProductType;
import com.example.cnpm.repository.CategoryRepository;
import com.example.cnpm.repository.ProductRepository;
import com.example.cnpm.repository.ProductTypeRepository;
import com.example.cnpm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductTypeRepository productTypeRepository;
    //phân trang sản phẩm
    @Override
    public Page<Product> findAll(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Override
    public Page<Product> findAllByCategoryId(Pageable page,int id) {
        return repository.findAllByCategoryId(page,id);
    }

    @Override
    public Iterable<Product> findAllByPriceBetween(float from, float to) {
        return repository.findAllByPriceBetween(from,to);
    }

    @Override
    public Product remove(Long id) {
        Product product=null;
        if(id!=null ){
            product=repository.findById(id);
            if(product!=null ){
                repository.delete(product);
            }
        }
        return null;
    }

//    @Override
//    public Product createOrUpdate(Product product) {
//        Product pr = null;
//        if (product.getId() != null) {
//            pr = repository.findById(product.getId());
//        }
//        if (pr == null)
//        {
//            pr = new Product();
//        }
//        pr.setDate(product.getDate());
//        pr.setDescription(product.getDescription());
//        pr.setImageFirst(product.getImageFirst());
//        pr.setImageRoot(product.getImageRoot());
//        pr.setImageSecond(product.getImageSecond());
//        pr.setNumber(product.getNumber());
//        pr.setPrice(product.getPrice());
//        pr.setSale(product.getSale());
//        pr.setStatus(product.getStatus());
//        pr.setTitle(product.getTitle());
//        pr.setCategory(categoryRepository.findById(product.getCategory().getId()));
//        pr.setProductType(productTypeRepository.findById(product.getProductType().getId()));
//        pr = repository.save(pr);
//        return new Product(pr) ;
//    }
}
