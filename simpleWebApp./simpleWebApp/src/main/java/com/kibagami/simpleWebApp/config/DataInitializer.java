package com.kibagami.simpleWebApp.config;

import com.kibagami.simpleWebApp.model.Product;
import com.kibagami.simpleWebApp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Initialise la base de données avec des produits de démonstration au démarrage.
 */
@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ProductRepository repository;

    @Override
    public void run(String... args) throws Exception {
        // Ajoute des produits initiaux si la base est vide
        if (repository.count() == 0) {
            repository.save(new Product(0, "Laptop", 999.99));
            repository.save(new Product(0, "Smartphone", 499.99));
            repository.save(new Product(0, "Tablet", 299.99));
            System.out.println("Base de données initialisée avec 3 produits.");
        }
    }
}

