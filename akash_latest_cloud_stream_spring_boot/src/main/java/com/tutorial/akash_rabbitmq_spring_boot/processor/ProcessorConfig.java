package com.tutorial.akash_rabbitmq_spring_boot.processor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ProcessorConfig {

    // as we have imported "Spring Cloud Function"... the Function Automatically Acts as a Endpoint with name as "toUpperCase"
    //Processor
    @Bean
    public Function<String, String> toUpperCase() {
        return (str) -> {
            str = str.toUpperCase();
            return str;
        };
    }
}
