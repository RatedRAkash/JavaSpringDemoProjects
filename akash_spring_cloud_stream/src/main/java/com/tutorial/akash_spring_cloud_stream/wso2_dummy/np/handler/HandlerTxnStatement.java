package com.tutorial.akash_spring_cloud_stream.wso2_dummy.np.handler;

import com.tutorial.akash_spring_cloud_stream.wso2_dummy.np.model.TxnType;
import com.tutorial.akash_spring_cloud_stream.wso2_dummy.np.processor.TxnTopicProcessor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(TxnTopicProcessor.class)
public class HandlerTxnStatement {

    @StreamListener(target = TxnTopicProcessor.TXN_TOPIC_INPUT)
    public void consumer1(TxnType txnType) {
        System.out.println("Consumer1 SEND_MONEY handled: " + txnType.toString());
    }

    @StreamListener(target = TxnTopicProcessor.TXN_TOPIC_INPUT)
    public void consumer2(TxnType txnType) {
        System.out.println("Consumer2 RECHARGE handled: " + txnType.toString());
    }
}