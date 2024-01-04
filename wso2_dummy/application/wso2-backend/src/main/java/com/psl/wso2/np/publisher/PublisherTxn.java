package com.psl.wso2.np.publisher;

import com.psl.wso2.np.dto.NotificationDto;
import com.psl.wso2.np.util.WSO2_Utils;
import com.psl.wso2.np.processor.topic.TxnTopicProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;


@EnableBinding(TxnTopicProcessor.class)
public class PublisherTxn {

    private static final Logger logger = LogManager.getLogger(PublisherTxn.class);

    private TxnTopicProcessor txnTopicProcessor;

    @Autowired
    public PublisherTxn(TxnTopicProcessor txnTopicProcessor) {
        this.txnTopicProcessor = txnTopicProcessor;
    }

    public void publishMessageToTxnTopic(NotificationDto notificationDto) {
        logger.info("PublisherTxn publishing ---> " + notificationDto.toString());
        txnTopicProcessor.txn_topic_output().send((WSO2_Utils.message(notificationDto)));
        logger.info("Sent Message to TxnTopic");
    }
}
