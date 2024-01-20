package com.tutorial.akash_rabbitmq_spring_boot.controller;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/")
public class MainRestController {

    private StreamBridge streamBridge;

    public MainRestController(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    // as we have imported "Spring Cloud Function"... the Function Automatically Acts as a Endpoint with name as "toUpperCase"
    // http://localhost:8080/toUpperCase/akash  ---> like this

    @PostMapping("produce")
    public ResponseEntity<String> values(@RequestBody String value) {
        System.out.println("Sending value to topic: " + value);
        streamBridge.send("ramos-data-producer-exchange", value); // "Producer-Input Exchange" Name
        return ResponseEntity.ok("ok");
    }
}
