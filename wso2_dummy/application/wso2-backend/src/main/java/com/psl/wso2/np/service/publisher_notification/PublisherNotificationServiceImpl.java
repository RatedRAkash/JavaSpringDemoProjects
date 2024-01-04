package com.psl.wso2.np.service.publisher_notification;

import com.psl.wso2.np.dto.formatted_dto.PushTemplateFormattedDto;
import com.psl.wso2.np.publisher.PublisherNotification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherNotificationServiceImpl implements PublisherNotificationService {
    private static final Logger logger = LogManager.getLogger(PublisherNotificationServiceImpl.class);

    private PublisherNotification publisherNotification;

    @Autowired
    public PublisherNotificationServiceImpl(PublisherNotification publisherNotification) {
        this.publisherNotification = publisherNotification;
    }

    @Override
    public void sendMessageToNotificationTopic(PushTemplateFormattedDto pushTemplateFormattedDto) {
        logger.info("sending via PublisherNotification");
        publisherNotification.publishMessageToNotificationTopic(pushTemplateFormattedDto);
    }
}
