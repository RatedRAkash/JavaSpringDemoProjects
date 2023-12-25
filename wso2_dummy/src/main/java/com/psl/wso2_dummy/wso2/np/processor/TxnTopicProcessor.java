package com.psl.wso2_dummy.wso2.np.processor;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface TxnTopicProcessor {
    String TXN_TOPIC = "TXN_TOPIC";

    @Input(TXN_TOPIC)
    SubscribableChannel txn_topic_input();

    @Output(TXN_TOPIC)
    MessageChannel txn_topic_output();
}
