package com.psl.wso2.np.service.publisher_notification;

import com.psl.wso2.np.dto.formatted_dto.PushTemplateFormattedDto;

public interface PublisherNotificationService {
    void sendMessageToNotificationTopic(PushTemplateFormattedDto pushTemplateFormattedDto);
}
