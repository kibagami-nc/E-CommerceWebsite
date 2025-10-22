package com.kibagami.simpleWebApp.controller;

import com.kibagami.simpleWebApp.model.Product;
import com.kibagami.simpleWebApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour les opérations liées aux produits.
 * Expose des endpoints pour lister, récupérer et ajouter des produits.
 */
@RestController
public class ProductController {

    // Injection du service qui gère les produits
    @Autowired
    ProductService service;

    /**
     * Récupère la liste complète des produits.
     * GET /products
     * @return liste de produits (sérialisée en JSON)
     */
    @GetMapping("/products")
    public List<Product> getProducts() {
        return service.getProducts();
    }

    /**
     * Récupère un produit par son identifiant interne (prodId).
     * GET /products/{prodId}
     * @param prodId identifiant du produit
     * @return le produit correspondant ou un produit de secours indiquant "not found"
     */
    @GetMapping("/products/{prodId}")
    public Product getProductById(@PathVariable int prodId) {
        return service.getProductsById(prodId);
    }

    /**
     * Ajoute un nouveau produit. Le produit est envoyé en JSON dans le corps de la requête.
     * POST /products
     * @param product objet Product désérialisé depuis la requête
     */
    @PostMapping("/products")
    public void addProduct(@RequestBody Product product) {
        // Affiche dans la console à des fins de debug
        System.out.println(product);
        service.addProduct(product);
    }

    @PutMapping("/products")
    public void updateProduct(@RequestBody Product product) {
        // Affiche dans la console à des fins de debug
        service.updateProduct(product);
        System.out.println(product);
    }

    @DeleteMapping("/products/{prodId}")
    public void deleteProduct(@PathVariable int prodId) {
        service.deleteProduct(prodId);
        System.out.println("Deleted product with id: " + prodId);
    }

}
