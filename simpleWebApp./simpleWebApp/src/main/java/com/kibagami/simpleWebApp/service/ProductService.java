package com.kibagami.simpleWebApp.service;

import com.kibagami.simpleWebApp.model.Product;
import com.kibagami.simpleWebApp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service qui gère les opérations sur les produits.
 * Utilise ProductRepository pour la persistance en base de données H2.
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    /**
     * Retourne la liste complète des produits depuis la base de données.
     * @return liste de produits
     */
    public List<Product> getProducts() {
        return repository.findAll();
    }

    /**
     * Récupère un produit par son identifiant depuis la base de données.
     * @param prodId identifiant recherché
     * @return produit trouvé ou produit factice indiquant "Product Not Found"
     */
    public Product getProductsById(int prodId) {
        return repository.findById(prodId)
                .orElse(new Product(0, "Product Not Found", 0));
    }

    /**
     * Ajoute un produit dans la base de données.
     * @param product produit à ajouter
     */
    public void addProduct(Product product) {
        repository.save(product);
    }

    /**
     * Met à jour un produit existant dans la base de données.
     * @param product produit à mettre à jour
     */
    public void updateProduct(Product product) {
        repository.save(product);
    }

    /**
     * Supprime un produit de la base de données par son identifiant.
     * @param prodId identifiant du produit à supprimer
     */
    public void deleteProduct(int prodId) {
        repository.deleteById(prodId);
    }
}
