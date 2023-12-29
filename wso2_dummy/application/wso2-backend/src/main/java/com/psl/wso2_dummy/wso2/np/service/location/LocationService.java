package com.psl.wso2_dummy.wso2.np.service.location;

import com.psl.wso2_dummy.wso2.np.dto.NotificationDto;
import psl.np.common.error.NpException;

public interface LocationService {

    void postLocationDataToNpBackend(NotificationDto notificationDto) throws NpException;
}
