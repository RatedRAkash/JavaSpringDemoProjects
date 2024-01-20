package com.tutorial.akash_rabbitmq_spring_boot.consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;


@Configuration
public class ConsumerConfig {

    //Consumer
    @Bean
    public Consumer<String> myConsumer() {
        return (str) -> {
            System.out.println("Message Consumer: " + str);
        };
    }
}