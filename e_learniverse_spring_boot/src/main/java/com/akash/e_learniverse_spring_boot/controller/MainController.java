package com.akash.e_learniverse_spring_boot.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/")
public class MainController {

    private static final Logger logger = LogManager.getLogger(MainController.class);


    @GetMapping("/home")
    public ResponseEntity<?> postNotification() {
        logger.info("Home Api");

        return ResponseEntity.ok("E-Learniverse Home Api");
    }
}