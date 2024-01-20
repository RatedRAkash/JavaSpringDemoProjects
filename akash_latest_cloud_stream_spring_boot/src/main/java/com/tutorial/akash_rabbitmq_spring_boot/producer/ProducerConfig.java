package com.tutorial.akash_rabbitmq_spring_boot.producer;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Supplier;

@Configuration
public class ProducerConfig {

    //Producer
    @Bean
    public Supplier<String> myProducer() {
        return () -> "sergio ramos";
    }
}
