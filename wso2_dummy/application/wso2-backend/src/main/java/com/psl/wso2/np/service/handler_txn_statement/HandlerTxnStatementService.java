package com.psl.wso2.np.service.handler_txn_statement;

import com.psl.wso2.np.dto.NotificationDto;

public interface HandlerTxnStatementService {
    void processMessage(NotificationDto notificationDto);
}
