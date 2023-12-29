package com.psl.wso2_dummy.wso2.np.service.txn_service;

import com.psl.wso2_dummy.wso2.np.dto.NotificationDto;

public interface TxnService {
    void sendMessageToTxnTopic(NotificationDto notificationDto);
}
