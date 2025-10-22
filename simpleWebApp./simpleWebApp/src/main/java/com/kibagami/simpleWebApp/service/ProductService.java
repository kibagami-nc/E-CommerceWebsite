package com.kibagami.simpleWebApp.service;

import com.kibagami.simpleWebApp.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Service qui gère les opérations en mémoire sur les produits.
 * Dans cette version simple, les produits sont stockés dans une liste en mémoire.
 * Dans une vraie application, on remplacerait cela par un accès à une base de données.
 */
@Service
public class ProductService {

    // Liste initiale de produits en mémoire
    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(101, "Laptop", 999.99),
            new Product(102, "Smartphone", 499.99),
            new Product(103, "Tablet", 299.99)));

    /**
     * Retourne la liste complète des produits.
     * @return liste de produits
     */
    public List<Product> getProducts() {
        return products;

    }

    /**
     * Récupère un produit par son identifiant interne.
     * @param prodId identifiant recherché
     * @return produit trouvé ou produit factice indiquant "Product Not Found"
     */
    public Product getProductsById(int prodId) {
        return products.stream()
                .filter(p -> p.getProdId()== prodId)
                .findFirst().orElse(new Product(0, "Product Not Found", 0));
    }

    /**
     * Ajoute un produit à la liste en mémoire.
     * @param product produit à ajouter
     */
    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProduct(Product product) {
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            if (p.getProdId() == product.getProdId()) {
                products.set(i, product);
                return;
            }
        }

    }

    public void deleteProduct(int prodId) {
        products.removeIf(p -> p.getProdId() == prodId);
    }
}
