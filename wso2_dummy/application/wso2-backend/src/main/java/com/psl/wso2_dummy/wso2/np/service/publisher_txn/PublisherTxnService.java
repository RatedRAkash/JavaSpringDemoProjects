package com.psl.wso2_dummy.wso2.np.service.publisher_txn;

import com.psl.wso2_dummy.wso2.np.dto.NotificationDto;

public interface PublisherTxnService {
    void sendMessageToTxnTopic(NotificationDto notificationDto);
}
