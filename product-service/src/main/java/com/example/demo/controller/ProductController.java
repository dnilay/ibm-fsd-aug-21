package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.exception.CouponNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import com.example.demo.shared.Coupon;

@RestController
@RequestMapping("/products")
public class ProductController {

	private Environment environment;
	private RestTemplate restTemplate;
	private ProductService productService;
	

	@Autowired
	public ProductController(Environment environment, RestTemplate restTemplate, ProductService productService) {

		this.environment = environment;
		this.restTemplate = restTemplate;
		this.productService = productService;
	}
	@GetMapping("/")
	public ResponseEntity<String> productHome()
	{
		return ResponseEntity.ok("product service is up and running on port: "+environment.getProperty("local.server.port"));
	}
	@PostMapping("/")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) throws CouponNotFoundException
	{
		Coupon coupon=restTemplate.getForObject("http://localhost:8010/coupons/"+product.getCouponCode(), Coupon.class);
		if(coupon == null)
		{
			throw new CouponNotFoundException("coupon code "+product.getCouponCode()+" is invalid");
		}
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(product));
		
	}

}
