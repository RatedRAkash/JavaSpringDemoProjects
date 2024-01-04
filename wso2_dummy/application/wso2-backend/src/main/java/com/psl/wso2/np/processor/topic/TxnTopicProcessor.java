package com.psl.wso2.np.processor.topic;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface TxnTopicProcessor {
    String TXN_TOPIC_INPUT1 = "TXN_TOPIC_INPUT1";
    String TXN_TOPIC_INPUT2 = "TXN_TOPIC_INPUT2";
    String TXN_TOPIC_INPUT3 = "TXN_TOPIC_INPUT3";
    String TXN_TOPIC_INPUT4 = "TXN_TOPIC_INPUT4";

    //OUTPUT
    String TXN_TOPIC_OUTPUT = "TXN_TOPIC_OUTPUT";

    @Input(TXN_TOPIC_INPUT1)
    SubscribableChannel txn_topic_input1();

    @Input(TXN_TOPIC_INPUT2)
    SubscribableChannel txn_topic_input2();

    @Input(TXN_TOPIC_INPUT3)
    SubscribableChannel txn_topic_input3();

    @Input(TXN_TOPIC_INPUT4)
    SubscribableChannel txn_topic_input4();


    //OUTPUT
    @Output(TXN_TOPIC_OUTPUT)
    MessageChannel txn_topic_output();
}
