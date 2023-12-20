package com.tutorial.akash_spring_cloud_stream.multipleProducerConsumer.producer;

import com.tutorial.akash_spring_cloud_stream.multipleProducerConsumer.processor.MyChannels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;


@EnableBinding(MyChannels.class)
public class MyCustomProducer {

    @Autowired
    private MyChannels myChannels;

    public MyCustomProducer(MyChannels myChannels) {
        this.myChannels = myChannels;
    }

    public void sendMessageInteger(Integer val) {
        if(val<11){
            System.out.println("Message Send Output1: " + val);
            myChannels.output1().send((message(val)));
        }else{
            System.out.println("Message Send Output2: " + val);
            myChannels.output2().send((message(val)));
        }
    }

    //TODO: orthat jei Type er message pathate chai tar "org.springframework.messaging.Message" Type Object Return korbo
    //    String hole Message<String> return korbo
    //    Integer hole Message<Integer> return korbo
    private static final <T> Message<T> message(T val) {
        return MessageBuilder.withPayload(val)
                .build();
    }
}