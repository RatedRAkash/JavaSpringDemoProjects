package com.tutorial.akash_thymeleaf_spring_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {
    @GetMapping("/")
    public String listStudents(Model model){
        return "layout/home";
    }
}
