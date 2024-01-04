package com.psl.wso2.np.handler;

import com.psl.wso2.np.dto.NotificationDto;
import com.psl.wso2.np.processor.topic.TxnTopicProcessor;
import com.psl.wso2.np.service.handler_location.HandlerLocationService;
import com.psl.wso2.np.service.handler_txn_notification.HandlerTxnNotificationService;
import com.psl.wso2.np.service.handler_txn_statement.HandlerTxnStatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import psl.np.common.error.NpException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.stream.annotation.EnableBinding;


@EnableBinding(TxnTopicProcessor.class)
public class HandlersOfTxnTopic {
    private static final Logger logger = LogManager.getLogger(HandlersOfTxnTopic.class);

    private final HandlerLocationService handlerLocationService;
    private final HandlerTxnNotificationService handlerTxnNotificationService;
    private final HandlerTxnStatementService handlerTxnStatementService;


    @Autowired
    public HandlersOfTxnTopic(HandlerLocationService handlerLocationService, HandlerTxnNotificationService handlerTxnNotificationService, HandlerTxnStatementService handlerTxnStatementService) {
        this.handlerLocationService = handlerLocationService;
        this.handlerTxnNotificationService = handlerTxnNotificationService;
        this.handlerTxnStatementService = handlerTxnStatementService;
    }


    @StreamListener(target = TxnTopicProcessor.TXN_TOPIC_INPUT1)
    public void handlerLocation(NotificationDto notificationDto) {
        System.out.println(Thread.currentThread().getName());
        logger.info("HandlerLocation consumed ---> " + notificationDto.getEventType());
        try {
            handlerLocationService.postLocationDataToNpBackend(notificationDto);
        }
        catch (NpException exception){
            logger.info("Calling NP Backend Failed");

            // TODO hala madrid: uncomment printStackTrace
//            exception.printStackTrace();
        }
    }

    @StreamListener(target = TxnTopicProcessor.TXN_TOPIC_INPUT2)
    public void handlerTxnNotification(NotificationDto notificationDto) {
        System.out.println(Thread.currentThread().getName());
        logger.info("HandlerTxnNotification consumed ---> " + notificationDto.getEventType());
        handlerTxnNotificationService.processMessageForPublisherNotification(notificationDto);
    }

    @StreamListener(target = TxnTopicProcessor.TXN_TOPIC_INPUT3)
    public void handlerTxnStatement(NotificationDto notificationDto) {
        logger.info("HandlerTxnStatementService consumed ---> " + notificationDto.getEventType());
        handlerTxnStatementService.processMessage(notificationDto);
    }


    @StreamListener(target = TxnTopicProcessor.TXN_TOPIC_INPUT4)
    public void handlerOffer(NotificationDto notificationDto) {
        logger.info("HandlerOffer consumed ---> " + notificationDto.getEventType());
    }
}