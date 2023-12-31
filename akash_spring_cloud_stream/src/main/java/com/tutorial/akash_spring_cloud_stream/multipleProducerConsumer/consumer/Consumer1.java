package com.tutorial.akash_spring_cloud_stream.multipleProducerConsumer.consumer;

import com.tutorial.akash_spring_cloud_stream.multipleProducerConsumer.processor.MyChannels;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(MyChannels.class)
public class Consumer1 {

    @StreamListener(MyChannels.INPUT_1)
    public void handleMessageFromTopic1(String message) {
        // Process messages from topic-1
        System.out.println("Consumer1 handled: " + message);
    }
}