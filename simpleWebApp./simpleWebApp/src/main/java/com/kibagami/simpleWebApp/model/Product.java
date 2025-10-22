package com.kibagami.simpleWebApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


/**
 * Modèle représentant un produit.
 * Contient les propriétés basiques : id, name et price.
 * On fournit des getters/setters classiques pour la sérialisation/désérialisation.
 * Annoté @Entity pour la persistance JPA avec la base de données H2.
 */
@Entity
public class Product {

    /**
     * Identifiant unique du produit, généré automatiquement par la base de données.
     * Exposé via le getter getProdId() sous la clé "prodId" dans le JSON.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product() {
    }

    /**
     * Getter pour l'id. Annoté @JsonIgnore pour que l'id ne soit pas sérialisé
     * dans la réponse JSON (utile si on ne veut pas exposer l'ID sous la clé "id").
     * @return identifiant interne
     */
    @JsonIgnore
    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Expose explicitement l'identifiant sous la clé "prodId" dans le JSON
     * de sortie et accepte aussi "prodId" à la désérialisation.
     */
    @JsonProperty("prodId")
    public int getProdId() {
        return id;
    }

    @JsonProperty("prodId")
    public void setProdId(int id) {
        this.id = id;
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
