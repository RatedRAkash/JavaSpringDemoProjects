package com.psl.wso2_dummy.wso2.np.service.handler_txn_notification;

import com.psl.wso2_dummy.wso2.np.dto.NotificationDto;

public interface HandlerTxnNotificationService {
    void processMessageForPublisherNotification(NotificationDto notificationDto);
}
