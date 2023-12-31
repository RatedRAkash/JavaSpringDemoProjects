package com.psl.wso2_dummy.wso2.np.service.handler_location;

import com.psl.wso2_dummy.wso2.np.client.NpBackendApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.psl.wso2_dummy.wso2.np.dto.NotificationDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import psl.np.common.error.NpException;

@Service
public class HandlerLocationServiceImpl implements HandlerLocationService {
    public static final Logger logger = LogManager.getLogger(HandlerLocationServiceImpl.class);

    private final NpBackendApi npBackendApi;

    @Autowired
    public HandlerLocationServiceImpl(NpBackendApi npBackendApi) {
        this.npBackendApi = npBackendApi;
    }

    @Override
    public void postLocationDataToNpBackend(NotificationDto notificationDto) throws NpException {

        logger.info("NP-Backend called for saving Location Data");
        this.npBackendApi.postLocationDataToNpBackend(notificationDto);
    }
}
