package com.psl.wso2_dummy.wso2.np.handler;

import com.psl.wso2_dummy.wso2.np.service.location.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import psl.np.common.error.NpException;
import psl.np.dataModel.dto.NotificationDto;
import com.psl.wso2_dummy.wso2.np.processor.TxnTopicProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(TxnTopicProcessor.class)
public class HandlerTxnStatement {
    private static final Logger logger = LogManager.getLogger(HandlerTxnStatement.class);

    private LocationService locationService;

    @Autowired
    public HandlerTxnStatement(LocationService locationService) {
        this.locationService = locationService;
    }

    @StreamListener(target = TxnTopicProcessor.TXN_TOPIC_INPUT)
    public void handlerLocation(NotificationDto notificationDto) {
        logger.info("handlerLocation consumed: " + notificationDto.getEventType());
        try {
            locationService.postLocationDataToNpBackend(notificationDto);
        }
        catch (NpException exception){
            logger.info("Calling NP Backend Failed");
        }
    }

    @StreamListener(target = TxnTopicProcessor.TXN_TOPIC_INPUT)
    public void handlerTxnNotification(NotificationDto notificationDto) {
        logger.info("handlerTxnNotification consumed: " + notificationDto.getEventType());
    }
}