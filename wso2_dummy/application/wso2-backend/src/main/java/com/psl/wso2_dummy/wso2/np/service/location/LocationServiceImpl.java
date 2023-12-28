package com.psl.wso2_dummy.wso2.np.service.location;

import org.springframework.stereotype.Service;
import psl.np.dataModel.dto.NotificationDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import psl.np.common.error.NpException;
import psl.np.common.restClient.NpRestClient;
import psl.np.common.restClient.api.NpBackendApiService;

@Service
public class LocationServiceImpl implements LocationService {
    public static final Logger logger = LogManager.getLogger(LocationServiceImpl.class);

    @Override
    public void postLocationDataToNpBackend(NotificationDto notificationDto) throws NpException {

        logger.info("NP-Backend called for saving Location Data");

        new NpRestClient<NpBackendApiService, Void>()
                .setBaseUrl("http://localhost:8080/nobopay-backend/")
                .callApi(NpBackendApiService.class, s -> s.saveLocationData(notificationDto));
    }
}
