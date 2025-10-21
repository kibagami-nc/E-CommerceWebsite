package com.kibagami.simpleWebApp.service;

import com.kibagami.simpleWebApp.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(101, "Laptop", 999.99),
            new Product(102, "Smartphone", 499.99),
            new Product(103, "Tablet", 299.99)));

    public List<Product> getProducts() {
        return products;

    }

    public Product getProductsById(int prodId) {
        return products.stream()
                .filter(p -> p.getProdId()== prodId)
                .findFirst().orElse(new Product(0, "Product Not Found", 0));
    }

    public void addProduct(Product product) {
        products.add(product);
    }

}
