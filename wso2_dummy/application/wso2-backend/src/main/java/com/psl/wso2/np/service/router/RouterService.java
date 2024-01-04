package com.psl.wso2.np.service.router;

import com.psl.wso2.np.dto.NotificationDto;

public interface RouterService {
    void routeMessage(NotificationDto notificationDto);
}