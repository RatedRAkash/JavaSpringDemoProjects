package com.psl.wso2_dummy.wso2.np.publisher;

import psl.np.dataModel.dto.NotificationDto;
import com.psl.wso2_dummy.wso2.np.processor.TxnTopicProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

@EnableBinding(TxnTopicProcessor.class)
public class PublisherTxn {

    private static final Logger logger = LogManager.getLogger(TxnTopicProcessor.class);

    @Autowired
    private TxnTopicProcessor txnTopicProcessor;

    public PublisherTxn(TxnTopicProcessor txnTopicProcessor) {
        this.txnTopicProcessor = txnTopicProcessor;
    }

    public void sendMessageToTxnTopic(NotificationDto notificationDto) {
        logger.info("TxnTopic received ---> " + notificationDto.toString());
        txnTopicProcessor.txn_topic_output().send((message(notificationDto)));
    }

    private static final <T> Message<T> message(T val) {
        return MessageBuilder.withPayload(val)
                .build();
    }
}
