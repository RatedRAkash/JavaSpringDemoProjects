package com.psl.wso2_dummy.wso2.np.publisher;

import com.psl.wso2_dummy.wso2.np.dto.PushTemplateFromattedDto;
import com.psl.wso2_dummy.wso2.np.processor.NotificationTopicProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;

import static com.psl.wso2_dummy.wso2.np.util.WSO2_Utils.message;


@EnableBinding(NotificationTopicProcessor.class)
public class PublisherNotification {
    private static final Logger logger = LogManager.getLogger(PublisherNotification.class);

    @Autowired
    private NotificationTopicProcessor notificationTopicProcessor;

    public PublisherNotification(NotificationTopicProcessor notificationTopicProcessor) {
        this.notificationTopicProcessor = notificationTopicProcessor;
    }

    public void sendMessageToNotificationTopic(PushTemplateFromattedDto pushTemplateFromattedDto) {
        logger.info("NotificationTopic received ---> " + pushTemplateFromattedDto.toString());
//        TODO Hala Madrid:
//        notificationTopicProcessor.notification_topic_output().send((message(pushTemplateFromattedDto)));
    }
}