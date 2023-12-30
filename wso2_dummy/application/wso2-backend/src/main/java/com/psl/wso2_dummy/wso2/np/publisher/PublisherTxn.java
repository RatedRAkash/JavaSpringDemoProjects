package com.psl.wso2_dummy.wso2.np.publisher;

import com.psl.wso2_dummy.wso2.np.dto.NotificationDto;
import com.psl.wso2_dummy.wso2.np.processor.TxnTopicProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;

import static com.psl.wso2_dummy.wso2.np.util.WSO2_Utils.message;


@EnableBinding(TxnTopicProcessor.class)
public class PublisherTxn {

    private static final Logger logger = LogManager.getLogger(PublisherTxn.class);

    @Autowired
    private TxnTopicProcessor txnTopicProcessor;

    public PublisherTxn(TxnTopicProcessor txnTopicProcessor) {
        this.txnTopicProcessor = txnTopicProcessor;
    }

    public void sendMessageToTxnTopic(NotificationDto notificationDto) {
        logger.info("TxnTopic received ---> " + notificationDto.toString());
        txnTopicProcessor.txn_topic_output().send((message(notificationDto)));
    }
}
