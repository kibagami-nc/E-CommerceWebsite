package com.kibagami.simpleWebApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principale de l'application Spring Boot.
 * Elle contient le point d'entrée (méthode main) qui démarre le contexte Spring.
 */
@SpringBootApplication
public class SimpleWebAppApplication {

    /**
     * Point d'entrée de l'application.
     * @param args arguments passés à la JVM (généralement non utilisés ici)
     */
    public static void main(String[] args) {
        SpringApplication.run(SimpleWebAppApplication.class, args);
    }

}
