package com.java_brains_tutorial.akash_spring_security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomController {

    @RequestMapping({"/homepage"})
    public String homepage(){
        return "Real Madrid";
    }
}
