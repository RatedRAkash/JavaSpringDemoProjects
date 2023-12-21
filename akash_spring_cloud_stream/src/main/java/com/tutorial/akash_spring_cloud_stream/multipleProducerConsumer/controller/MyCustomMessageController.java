package com.tutorial.akash_spring_cloud_stream.multipleProducerConsumer.controller;

import com.tutorial.akash_spring_cloud_stream.multipleProducerConsumer.model.FootballPlayer;
import com.tutorial.akash_spring_cloud_stream.multipleProducerConsumer.producer.MyCustomProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyCustomMessageController {

    private MyCustomProducer customProducer;


    @Autowired
    public MyCustomMessageController(MyCustomProducer customProducer) {
        this.customProducer = customProducer;
    }


    @PostMapping("/publish-multiple")
    public ResponseEntity publishMultipleMessage(@RequestBody FootballPlayer player){

        customProducer.sendMessageInteger(player.getJersey_no());
        return ResponseEntity.ok("Message Published: " + player);
    }
}
