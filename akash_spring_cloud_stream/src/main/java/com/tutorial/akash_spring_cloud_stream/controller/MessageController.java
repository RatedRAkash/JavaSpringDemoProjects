package com.tutorial.akash_spring_cloud_stream.controller;

import com.tutorial.akash_spring_cloud_stream.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private MessageProducer messageProducer;

    @Autowired
    public MessageController(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity publishMessage(@RequestBody String message){
        messageProducer.sendMessage(message);
        return ResponseEntity.ok("Message Published" + message);
    }
}
