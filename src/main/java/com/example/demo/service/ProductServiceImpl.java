package com.example.demo.service;

import com.example.demo.dao.ProductDao;
import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@EnableTransactionManagement
public class ProductServiceImpl implements ProductService{
    private ProductDao productDao;
    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    @Transactional
    public Product createProduct(Product product) {
        return productDao.save(product);
    }

    @Override
    @Transactional
    public List<Product> fetchProduct() {
        return productDao.findAll();
    }

    @Override
    public Product getProduct(Integer id) {
        return productDao.findById(id).get();
    }
}
