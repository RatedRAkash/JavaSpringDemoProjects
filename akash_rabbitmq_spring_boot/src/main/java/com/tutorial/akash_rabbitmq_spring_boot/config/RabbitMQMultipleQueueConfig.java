package com.tutorial.akash_rabbitmq_spring_boot.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQMultipleQueueConfig {

//  There will be 1 EXCHANGE, this EXCHANGE will be Connected with 2 QUEUES
    @Value("${rabbitmq.exchange.name}")
    private String exchange_name;

//  QUEUE Config 1
    @Value("${rabbitmq.queue.name}")
    private String queue_name;

    @Value("${rabbitmq.routing_key.name}")
    private String routing_key_name;


//  QUEUE Config 2
    @Value("${rabbitmq.queue2.name}")
    private String queue_name2;

    @Value("${rabbitmq.routing_key2.name}")
    private String routing_key_name2;

    //  spring bean for rabbitmq Queue
    @Bean
    public Queue getQueue(){
        return new Queue(queue_name);
    }

    @Bean
    public TopicExchange getExchange(){
        return new TopicExchange(exchange_name);
    }

    //  spring bean for rabbitmq Queue
    @Bean
    public Queue getQueue2(){
        return new Queue(queue_name2);
    }


    // binding between EXCHANGE and QUEUE using ROUTING_KEY
    @Bean
    public Binding binding(){
        return BindingBuilder
                .bind(getQueue())
                .to(getExchange())
                .with(routing_key_name);
    }


    // this Queue will be used for binding JSON data...it is "jsonBinding()" in Tutorial
    @Bean
    public Binding binding2(){
        return BindingBuilder
                .bind(getQueue2())
                .to(getExchange())
                .with(routing_key_name2);
    }

// TODO: Spring Boot nicher Class gular BEAN Auto Configure kore dey Internally... but "Normal Spring"(Not Spring Boot) eigula agge korto Nah
    // ConnectionFactory
    // RabbitTemplate
    // RabbitAdmin


    //TODO: We now will use CUSTOMIZE RabbitTemplate which will support CONVERTING JSON data
    @Bean
    public MessageConverter getConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(getConverter());
        return rabbitTemplate;
    }

}
