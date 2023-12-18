package com.tutorial.akash_rabbitmq_spring_boot.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.amqp.rabbit.annotation.RabbitListener;


@Service
public class RabbiqMQConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbiqMQConsumer.class);

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void consume(String message){
        LOGGER.info(String.format("Received message ---> %s", message));
    }

}
