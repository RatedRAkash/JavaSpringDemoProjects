package com.tutorial.akash_spring_cloud_stream.consumer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class MessageConsumer2 {

    @StreamListener(Sink.INPUT)
    public void handleMessage(String message) {
        System.out.println("Consumer 2 Received: " + message);
    }
}
