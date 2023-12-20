package com.tutorial.akash_spring_cloud_stream.producer;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;

@EnableBinding(Source.class)
public class MessageProducer {

    private final Source source;

    public MessageProducer(Source source) {
        this.source = source;
    }

    public void sendMessage(String message) {
        source.output().send(MessageBuilder.withPayload(message).build());
    }
}

