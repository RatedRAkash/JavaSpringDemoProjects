package com.psl.wso2_dummy.wso2.np.handler;

import com.psl.wso2_dummy.wso2.np.dto.PushTemplateFromattedDto;
import com.psl.wso2_dummy.wso2.np.processor.NotificationTopicProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(NotificationTopicProcessor.class)
public class HandlerNotificationTopic {
    private static final Logger logger = LogManager.getLogger(HandlerNotificationTopic.class);

    @StreamListener(target = NotificationTopicProcessor.NOTIFICATION_TOPIC_INPUT)
    public void handlerTxnSms(PushTemplateFromattedDto pushTemplateFromattedDto) {
        logger.info("HandlerTxnSms consumed ---> " + pushTemplateFromattedDto.toString());
    }

    @StreamListener(target = NotificationTopicProcessor.NOTIFICATION_TOPIC_INPUT)
    public void handlerFCM(PushTemplateFromattedDto pushTemplateFromattedDto) {
        logger.info("HandlerFCM consumed ---> " + pushTemplateFromattedDto.toString());
    }

}
