package com.kibagami.simpleWebApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


/**
 * Modèle représentant un produit.
 * Contient les propriétés basiques : id, name et price.
 * Annoté @Entity pour la persistance JPA avec la base de données H2.
 */
@Entity
public class Product {

    /**
     * Identifiant unique du produit, généré automatiquement par la base de données.
     * Exposé via la clé JSON "prodId" en lecture seule (le client ne doit pas pouvoir
     * imposer un identifiant lors d'une création).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(value = "prodId", access = Access.READ_ONLY)
    private Integer id;
    private String name;
    private double price;

    public Product(Integer id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
