package com.psl.wso2.np.service.handler_location;

import com.psl.wso2.np.dto.NotificationDto;
import psl.np.common.error.NpException;

public interface HandlerLocationService {
    void postLocationDataToNpBackend(NotificationDto notificationDto) throws NpException;
}
