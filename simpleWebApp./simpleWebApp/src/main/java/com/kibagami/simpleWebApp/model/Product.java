package com.kibagami.simpleWebApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;


/**
 * Modèle représentant un produit.
 * Contient les propriétés basiques : id, name et price.
 * On fournit des getters/setters classiques pour la sérialisation/désérialisation.
 */
@Component
public class Product {

    // Identifiant interne du produit (visible en interne mais non renvoyé au client)
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
     * dans la réponse JSON (utile si on ne veut pas exposer l'ID dans Postman/UI).
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
     * Getter alternatif pour l'usage interne si besoin (également ignoré pour la sérialisation).
     */
    @JsonIgnore
    public int getProdId() {
        return id;
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
