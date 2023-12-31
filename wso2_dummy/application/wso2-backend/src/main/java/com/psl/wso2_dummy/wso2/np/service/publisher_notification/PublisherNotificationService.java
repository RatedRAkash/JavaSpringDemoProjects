package com.psl.wso2_dummy.wso2.np.service.publisher_notification;

import com.psl.wso2_dummy.wso2.np.dto.PushTemplateFormattedDto;

public interface PublisherNotificationService {
    void sendMessageToNotificationTopic(PushTemplateFormattedDto pushTemplateFormattedDto);
}
