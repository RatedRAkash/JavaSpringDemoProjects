package com.psl.wso2_dummy.wso2.np.handler;

import com.psl.wso2_dummy.wso2.np.service.location.LocationService;
import com.psl.wso2_dummy.wso2.np.service.txn_notification.TxnNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import psl.np.common.error.NpException;
import com.psl.wso2_dummy.wso2.np.dto.NotificationDto;
import com.psl.wso2_dummy.wso2.np.processor.TxnTopicProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(TxnTopicProcessor.class)
public class HandlerTxnStatement {
    private static final Logger logger = LogManager.getLogger(HandlerTxnStatement.class);

    private LocationService locationService;
    private TxnNotificationService txnNotificationService;


    @Autowired
    public HandlerTxnStatement(LocationService locationService, TxnNotificationService txnNotificationService) {
        this.locationService = locationService;
        this.txnNotificationService = txnNotificationService;
    }


    @StreamListener(target = TxnTopicProcessor.TXN_TOPIC_INPUT)
    public void handlerLocation(NotificationDto notificationDto) {
        logger.info("HandlerLocation consumed ---> " + notificationDto.getEventType());
        try {
            locationService.postLocationDataToNpBackend(notificationDto);
        }
        catch (NpException exception){
            logger.info("Calling NP Backend Failed");

            // TODO hala madrid: uncomment printStackTrace
//            exception.printStackTrace();
        }
    }


    @StreamListener(target = TxnTopicProcessor.TXN_TOPIC_INPUT)
    public void handlerTxnNotification(NotificationDto notificationDto) {
        logger.info("HandlerTxnNotification consumed ---> " + notificationDto.getEventType());
        txnNotificationService.processMessageForPublisherNotification(notificationDto);
    }
}