package com.tutorial.akash_retrofit_client_spring_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/")
    String home(){
        return "home";
    }
}
