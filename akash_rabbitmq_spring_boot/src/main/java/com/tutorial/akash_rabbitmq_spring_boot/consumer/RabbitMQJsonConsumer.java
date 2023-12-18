package com.tutorial.akash_rabbitmq_spring_boot.consumer;

import com.tutorial.akash_rabbitmq_spring_boot.dto.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class RabbitMQJsonConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonConsumer.class);

    @RabbitListener(queues = "${rabbitmq.queue2.name}")
    public void consume(Student student){  //RabbitTemplate jeita amra Create korsi sheita autmatic JsonObject ke Student Class ee Convert kore nibe
        LOGGER.info(String.format("Received message ---> %s", student.toString()));
    }

}
