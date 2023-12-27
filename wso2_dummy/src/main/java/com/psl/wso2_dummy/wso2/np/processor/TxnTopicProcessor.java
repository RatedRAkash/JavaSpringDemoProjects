package com.psl.wso2_dummy.wso2.np.processor;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface TxnTopicProcessor {
    String TXN_TOPIC_INPUT = "TXN_TOPIC_INPUT";
    String TXN_TOPIC_OUTPUT = "TXN_TOPIC_OUTPUT";

    @Input(TXN_TOPIC_INPUT)
    SubscribableChannel txn_topic_input();

    @Output(TXN_TOPIC_OUTPUT)
    MessageChannel txn_topic_output();
}
