package com.learning.Spring_Security.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String greet(HttpServletRequest req){
        return "HELLLOOO!!!  " + req.getSession().getId();
    }
}
