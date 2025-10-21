package com.kibagami.simpleWebApp.controller;

import com.kibagami.simpleWebApp.model.Product;
import com.kibagami.simpleWebApp.service.ProductService;
import com.sun.source.util.SourcePositions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @GetMapping("products/{prodId}")
    public Product getProductById(@PathVariable int prodId) {
        return service.getProductsById(prodId);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product product) {
        System.out.println(product);
        service.addProduct(product);
    }


}

