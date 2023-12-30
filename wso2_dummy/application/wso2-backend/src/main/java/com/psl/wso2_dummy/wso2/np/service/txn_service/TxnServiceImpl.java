package com.psl.wso2_dummy.wso2.np.service.txn_service;

import com.psl.wso2_dummy.wso2.np.dto.NotificationDto;
import com.psl.wso2_dummy.wso2.np.publisher.PublisherTxn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TxnServiceImpl implements TxnService {
    private static final Logger logger = LogManager.getLogger(TxnServiceImpl.class);

    private PublisherTxn publisherTxn;

    @Autowired
    public TxnServiceImpl(PublisherTxn publisherTxn) {
        this.publisherTxn = publisherTxn;
    }

    @Override
    public void sendMessageToTxnTopic(NotificationDto notificationDto) {
        logger.info("publisherTxn ---> publishing message: " + notificationDto.getEventType());
        publisherTxn.sendMessageToTxnTopic(notificationDto);
    }
}
