package com.kibagami.simpleWebApp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Contrôleur simple pour les pages d'accueil et d'information.
 * Les méthodes exposent des endpoints REST qui retournent des chaînes de caractères.
 */
@RestController
public class HomeController {

    /**
     * Endpoint racine (/)
     * @return message de bienvenue
     */
    @RequestMapping("/")
    public String home() {
        return "Welcome to the Simple Web App!";
    }

    /**
     * Endpoint /about
     * @return description courte de l'application
     */
    @RequestMapping("/about")
    public String about() {
        return "This is a simple web application built with Spring Boot.";
    }

}
