package com.tutorial.akash_rabbitmq_spring_boot.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class RabbitMQProducer {
//    TODO: Producer Message Publish korar somoy QUEUE er name Lagge NAH, Message ta khali Exchange er moddhe Routing_Key diye BIND korlei Automatic Corresponding Queue te Push hoye jabe
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQProducer.class);

    @Value("${rabbitmq.exchange.name}")
    private String exchange_name;

    @Value("${rabbitmq.routing_key.name}")
    private String routing_key_name;


    private RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessageToMessageBroker(String message){
        LOGGER.info(String.format("Normal Message sent ---> %s", message));

        //routing_key Automatic jei Queue er sathe Bind ase shei Queue er kase Message niye jabe
        rabbitTemplate.convertAndSend(exchange_name, routing_key_name, message);
    }
}
