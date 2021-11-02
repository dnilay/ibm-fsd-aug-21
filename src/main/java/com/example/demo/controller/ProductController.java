package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(product));
    }
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts()
    {
        return ResponseEntity.ok(productService.fetchProduct());
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Integer id)
    {
        return ResponseEntity.ok(productService.getProduct(id));
    }
    @PutMapping("/products")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product)
    {
        return ResponseEntity.ok(productService.updateProduct(product));
    }
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") Integer id)
    {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }
}
