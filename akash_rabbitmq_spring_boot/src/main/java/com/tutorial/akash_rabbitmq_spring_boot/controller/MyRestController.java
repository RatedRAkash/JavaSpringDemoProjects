package com.tutorial.akash_rabbitmq_spring_boot.controller;

import com.tutorial.akash_rabbitmq_spring_boot.dto.Student;
import com.tutorial.akash_rabbitmq_spring_boot.publisher.RabbitMQJsonProducer;
import com.tutorial.akash_rabbitmq_spring_boot.publisher.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MyRestController {
    private RabbitMQProducer producer;
    private RabbitMQJsonProducer jsonProducer;

    @Autowired
    public MyRestController(RabbitMQProducer producer, RabbitMQJsonProducer jsonProducer) {
        this.producer = producer;
        this.jsonProducer = jsonProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        producer.sendMessageToMessageBroker(message);
        return ResponseEntity.ok("Normal Message sent to RabbitMQ ...");
    }

    @GetMapping("/publish-student-obj")
    public ResponseEntity<String> sendJsonMessage(@RequestBody Student student){
        jsonProducer.sendJsonMessageToMessageBroker(student);
        return ResponseEntity.ok("JsonMessage sent to RabbitMQ ...");
    }
}
