package com.psl.wso2.np.processor.topic;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;


public interface NotificationTopicProcessor {
    String NOTIFICATION_TOPIC_INPUT1 = "NOTIFICATION_TOPIC_INPUT1";
    String NOTIFICATION_TOPIC_INPUT2 = "NOTIFICATION_TOPIC_INPUT2";

    //OUTPUT
    String NOTIFICATION_TOPIC_OUTPUT = "NOTIFICATION_TOPIC_OUTPUT";


    @Input(NOTIFICATION_TOPIC_INPUT1)
    SubscribableChannel notification_topic_input1();

    @Input(NOTIFICATION_TOPIC_INPUT2)
    SubscribableChannel notification_topic_input2();


    //OUTPUT
    @Output(NOTIFICATION_TOPIC_OUTPUT)
    MessageChannel notification_topic_output();
}