package com.tutorial.akash_rabbitmq_spring_boot.controller;

import com.tutorial.akash_rabbitmq_spring_boot.publisher.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MyRestController {
    private RabbitMQProducer producer;

    @Autowired
    public MyRestController(RabbitMQProducer producer) {
        this.producer = producer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        producer.sendMessageToMessageBroker(message);
        return ResponseEntity.ok("Message sent to RabbitMQ ...");
    }
}
