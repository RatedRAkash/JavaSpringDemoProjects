package com.psl.wso2_dummy.wso2.np.handler;

import com.psl.wso2_dummy.wso2.np.model.TxnType;
import com.psl.wso2_dummy.wso2.np.processor.TxnTopicProcessor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(TxnTopicProcessor.class)
public class HandlerTxnStatement {

    @StreamListener(target = TxnTopicProcessor.TXN_TOPIC)
    public void consumer1(TxnType txnType) {
        System.out.println("Consumer1 SEND_MONEY handled: " + txnType.toString());
    }

//    @StreamListener(
//            target = TxnTopicProcessor.TXN_TOPIC_INPUT,
//            condition = "payload.txnType.equals('RECHARGE')")
//    public void consumer2(TxnType txnType) {
//        System.out.println("Consumer2 RECHARGE handled: " + txnType.toString());
//    }
}