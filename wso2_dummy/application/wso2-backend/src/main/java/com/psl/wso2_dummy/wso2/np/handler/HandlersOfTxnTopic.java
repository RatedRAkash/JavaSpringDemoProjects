package com.psl.wso2_dummy.wso2.np.handler;

import com.psl.wso2_dummy.wso2.np.service.handler_location.HandlerLocationService;
import com.psl.wso2_dummy.wso2.np.service.handler_txn_notification.HandlerTxnNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import psl.np.common.error.NpException;
import com.psl.wso2_dummy.wso2.np.dto.NotificationDto;
import com.psl.wso2_dummy.wso2.np.processor.TxnTopicProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(TxnTopicProcessor.class)
public class HandlersOfTxnTopic {
    private static final Logger logger = LogManager.getLogger(HandlersOfTxnTopic.class);

    private final HandlerLocationService handlerLocationService;
    private final HandlerTxnNotificationService handlerTxnNotificationService;


    @Autowired
    public HandlersOfTxnTopic(HandlerLocationService handlerLocationService, HandlerTxnNotificationService handlerTxnNotificationService) {
        this.handlerLocationService = handlerLocationService;
        this.handlerTxnNotificationService = handlerTxnNotificationService;
    }


//    TODO hala Madrid:
//     @StreamListener(target = TxnTopicProcessor.TXN_TOPIC_INPUT)
    public void handlerLocation(NotificationDto notificationDto) {
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


    @StreamListener(target = TxnTopicProcessor.TXN_TOPIC_INPUT)
    public void handlerTxnNotification(NotificationDto notificationDto) {
        logger.info("HandlerTxnNotification consumed ---> " + notificationDto.getEventType());
        handlerTxnNotificationService.processMessageForPublisherNotification(notificationDto);
    }
}