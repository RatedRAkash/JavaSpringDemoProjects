package com.psl.wso2.np.publisher;

import com.psl.wso2.np.dto.formatted_dto.PushTemplateFormattedDto;
import com.psl.wso2.np.util.WSO2_Utils;
import com.psl.wso2.np.processor.topic.NotificationTopicProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;


@EnableBinding(NotificationTopicProcessor.class)
public class PublisherNotification {
    private static final Logger logger = LogManager.getLogger(PublisherNotification.class);

    private NotificationTopicProcessor notificationTopicProcessor;

    @Autowired
    public PublisherNotification(NotificationTopicProcessor notificationTopicProcessor) {
        this.notificationTopicProcessor = notificationTopicProcessor;
    }


    public void publishMessageToNotificationTopic(PushTemplateFormattedDto pushTemplateFormattedDto) {
        logger.info("PublisherNotification publishing ---> " + pushTemplateFormattedDto.toString());
        notificationTopicProcessor.notification_topic_output().send((WSO2_Utils.message(pushTemplateFormattedDto)));
        logger.info("Sent Message to NotificationTopic");
    }
}