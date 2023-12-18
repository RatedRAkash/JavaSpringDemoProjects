package com.tutorial.akash_rabbitmq_spring_boot.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbiMQConfig {

// TODO: *** Theory ***
    // Spring Boot or jekono Web Application RabbitMQ te jei Message pathai sheigula agge "EXCHANGE" er kase pathay, then Exchange "Routing_Key" er name dekhe QUEUE ke Forward kore
    // ekta "Exchange" er under ee Multiple "Queue" er Individual Unique "Routing Key" diye Bind takhe...
    // kintu 1 ta Queue Ekadik(Many) "Exchange" er Under ee jaite parbe Nah...

    // Routing Key diye kono Exchange bujhe kon Queue ke pathate hobe
    // So, Routing Key is UNIQUE for a Exchange and Queue CONNECTION


// TODO: Spring Boot nicher Class gular BEAN Auto Configure kore dey Internally... but "Normal Spring"(Not Spring Boot) eigula agge korto Nah
    // ConnectionFactory
    // RabbitTemplate
    // RabbitAdmin

    @Value("${rabbitmq.queue.name}")
    private String queue_name;

    @Value("${rabbitmq.exchange.name}")
    private String exchange_name;

    @Value("${rabbitmq.routing_key.name}")
    private String routing_key_name;

    //  spring bean for rabbitmq Queue
    @Bean
    public Queue getQueue(){
        return new Queue(queue_name);
    }

    @Bean
    public TopicExchange getExchange(){
        return new TopicExchange(exchange_name);
    }


    // binding between EXCHANGE and QUEUE using ROUTING_KEY
    @Bean
    public Binding binding(){
        return BindingBuilder
                .bind(getQueue())
                .to(getExchange())
                .with(routing_key_name);
    }
}
