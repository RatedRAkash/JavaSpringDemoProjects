package com.tutorial.akash_rabbitmq_spring_boot.publisher;

import com.tutorial.akash_rabbitmq_spring_boot.dto.FootballPlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonProducer {
//    TODO: Producer Message Publish korar somoy QUEUE er name Lagge NAH, Message ta khali Exchange er moddhe Routing_Key diye BIND korlei Automatic Corresponding Queue te Push hoye jabe

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonProducer.class);

    @Value("${rabbitmq.exchange.name}")
    private String exchange_name;

    @Value("${rabbitmq.routing_key2.name}")
    private String routing_key_name2;


    private RabbitTemplate rabbitTemplate;

//  config.RabbitMQMultipleQueueConfig  ---> ei Class er rabbitTemplate jei @Bean annotations dewa ase sheita eshe Autowired hpbe
    @Autowired
    public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendJsonMessageToMessageBroker(FootballPlayer footballPlayer){
        LOGGER.info(String.format("JsonMessage sent ---> %s", footballPlayer.toString()));

        //Student Class Converted Json hobe & then Queue er kase push korbe
        rabbitTemplate.convertAndSend(exchange_name, routing_key_name2, footballPlayer);
    }
}
