package com.psl.wso2_dummy.wso2.np.handler;

import com.psl.wso2_dummy.wso2.np.dto.formatted_dto.PushTemplateFormattedDto;
import com.psl.wso2_dummy.wso2.np.processor.NotificationTopicProcessor;
import com.psl.wso2_dummy.wso2.np.service.handler_fcm.HandlerFCMService;
import com.psl.wso2_dummy.wso2.np.service.handler_txn_sms.HandlerTxnSmsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;


@EnableBinding(NotificationTopicProcessor.class)
public class HandlersOfNotificationTopic {
    private static final Logger logger = LogManager.getLogger(HandlersOfNotificationTopic.class);

    private final HandlerTxnSmsService handlerTxnSmsService;
    private final HandlerFCMService handlerFCMService;

    @Autowired
    public HandlersOfNotificationTopic(HandlerTxnSmsService handlerTxnSmsService, HandlerFCMService handlerFCMService) {
        this.handlerTxnSmsService = handlerTxnSmsService;
        this.handlerFCMService = handlerFCMService;
    }

    @StreamListener(target = NotificationTopicProcessor.NOTIFICATION_TOPIC_INPUT)
    public void handlerTxnSms(PushTemplateFormattedDto pushTemplateFormattedDto) {
        logger.info("HandlerTxnSms consumed ---> " + pushTemplateFormattedDto.toString());
        handlerTxnSmsService.processMessageForSenderSms(pushTemplateFormattedDto);
    }

    @StreamListener(target = NotificationTopicProcessor.NOTIFICATION_TOPIC_INPUT)
    public void handlerFCM(PushTemplateFormattedDto pushTemplateFormattedDto) {
        logger.info("HandlerFCM consumed ---> " + pushTemplateFormattedDto.toString());
        handlerFCMService.processMessageForSendingToFCMService(pushTemplateFormattedDto);
    }

}
