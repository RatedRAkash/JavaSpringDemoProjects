package com.psl.wso2.np.service.publisher_txn;

import com.psl.wso2.np.dto.NotificationDto;
import com.psl.wso2.np.publisher.PublisherTxn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherTxnServiceImpl implements PublisherTxnService {
    private static final Logger logger = LogManager.getLogger(PublisherTxnServiceImpl.class);

    private PublisherTxn publisherTxn;

    @Autowired
    public PublisherTxnServiceImpl(PublisherTxn publisherTxn) {
        this.publisherTxn = publisherTxn;
    }

    @Override
    public void sendMessageToTxnTopic(NotificationDto notificationDto) {
        logger.info("sending via PublisherTxn");
        publisherTxn.publishMessageToTxnTopic(notificationDto);
    }
}