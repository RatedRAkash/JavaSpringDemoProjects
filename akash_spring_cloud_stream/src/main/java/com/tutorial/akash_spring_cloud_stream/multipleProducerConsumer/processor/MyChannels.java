package com.tutorial.akash_spring_cloud_stream.multipleProducerConsumer.processor;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MyChannels {
    String INPUT_1 = "input1";
    String INPUT_2 = "input2";

    String OUTPUT_1 = "output1";
    String OUTPUT_2 = "output2";



    @Input(INPUT_1)
    SubscribableChannel input1();

    @Input(INPUT_2)
    SubscribableChannel input2();

    @Output(OUTPUT_1)
    MessageChannel output1();

    @Output(OUTPUT_2)
    MessageChannel output2();
}
