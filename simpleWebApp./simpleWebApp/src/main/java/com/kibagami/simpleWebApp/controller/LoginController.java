package com.kibagami.simpleWebApp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Contrôleur pour la route /login.
 * Dans cette application simple, il retourne un message statique.
 * Dans une vraie application, on y gèrerait l'authentification.
 */
@RestController
public class LoginController {

    /**
     * Endpoint /login
     * @return message invitant à saisir des identifiants
     */
    @RequestMapping("/login")
    public String login() {
        return "Please enter your credentials to log in.";
    }

}
