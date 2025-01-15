package com.example.taco_security.controller;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String index(){
        return "home";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/home")
    public String home(){
        return "Available for all users";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/secureHome")
    public String secureHome(){
        return  "Available For Admin Users Only";
    }
}
