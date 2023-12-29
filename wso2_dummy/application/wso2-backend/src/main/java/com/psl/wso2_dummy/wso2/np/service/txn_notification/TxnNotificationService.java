package com.psl.wso2_dummy.wso2.np.service.txn_notification;

import com.psl.wso2_dummy.wso2.np.dto.NotificationDto;

public interface TxnNotificationService {
    void processMessageForPublisherNotification(NotificationDto notificationDto);
}
