package com.kibagami.simpleWebApp.repository;

import com.kibagami.simpleWebApp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository JPA pour gérer la persistance des produits.
 * JpaRepository fournit automatiquement les méthodes CRUD de base.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}

