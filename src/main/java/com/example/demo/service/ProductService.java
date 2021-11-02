package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;

public interface ProductService {

    public Product createProduct(Product product);
    public List<Product> fetchProduct();
    public Product getProduct(Integer id);
}
