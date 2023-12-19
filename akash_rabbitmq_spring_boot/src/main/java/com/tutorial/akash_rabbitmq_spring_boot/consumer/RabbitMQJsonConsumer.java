package com.tutorial.akash_rabbitmq_spring_boot.consumer;

import com.tutorial.akash_rabbitmq_spring_boot.dto.FootballPlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonConsumer.class);

    @RabbitListener(queues = "${rabbitmq.queue2.name}")
    public void consume(FootballPlayer footballPlayer){  //RabbitTemplate jeita amra Create korsi sheita autmatic JsonObject ke Student Class ee Convert kore nibe
        LOGGER.info(String.format("Received JsonMessage ---> %s", footballPlayer.toString()));
    }

}
