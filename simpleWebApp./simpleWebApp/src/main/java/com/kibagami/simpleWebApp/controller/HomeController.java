package com.kibagami.simpleWebApp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "Welcome to the Simple Web App!";
    }

    @RequestMapping("/about")
    public String about() {
        return "This is a simple web application built with Spring Boot.";
    }

}
