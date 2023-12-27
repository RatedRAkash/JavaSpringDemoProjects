package com.tutorial.akash_spring_cloud_stream.wso2_dummy.np.publisher;

import com.tutorial.akash_spring_cloud_stream.wso2_dummy.np.model.TxnType;
import com.tutorial.akash_spring_cloud_stream.wso2_dummy.np.processor.TxnTopicProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

@EnableBinding(TxnTopicProcessor.class)
public class PublisherTxn {

    @Autowired
    private TxnTopicProcessor txnTopicProcessor;

    public PublisherTxn(TxnTopicProcessor txnTopicProcessor) {
        this.txnTopicProcessor = txnTopicProcessor;
    }

    public void sendMessage(TxnType txnType) {
        System.out.println("Txn-Topic Published: " + txnType.toString());
        txnTopicProcessor.txn_topic_output().send((message(txnType)));
    }

    private static final <T> Message<T> message(T val) {
        return MessageBuilder.withPayload(val)
                .build();
    }
}
