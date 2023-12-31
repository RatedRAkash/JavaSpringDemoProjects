package com.tutorial.akash_spring_cloud_stream.multipleProducerConsumer.consumer;

import com.tutorial.akash_spring_cloud_stream.multipleProducerConsumer.processor.MyChannels;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(MyChannels.class)
public class Consumer2 {

    @StreamListener(MyChannels.INPUT_2)
    public void handleMessageFromTopic2(String message) {
        // Process messages from topic-2
        System.out.println("Consumer2 handled: " + message);
    }
}