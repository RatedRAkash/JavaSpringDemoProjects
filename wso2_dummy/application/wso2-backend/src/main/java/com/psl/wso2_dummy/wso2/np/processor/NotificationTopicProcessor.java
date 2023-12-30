package com.psl.wso2_dummy.wso2.np.processor;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;


public interface NotificationTopicProcessor {
    String NOTIFICATION_TOPIC_INPUT = "NOTIFICATION_TOPIC_INPUT";
    String NOTIFICATION_TOPIC_OUTPUT = "NOTIFICATION_TOPIC_OUTPUT";

    @Input(NOTIFICATION_TOPIC_INPUT)
    SubscribableChannel notification_topic_input();

    @Output(NOTIFICATION_TOPIC_OUTPUT)
    MessageChannel notification_topic_output();
}