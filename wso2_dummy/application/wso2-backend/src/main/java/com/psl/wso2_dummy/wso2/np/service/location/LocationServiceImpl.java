package com.psl.wso2_dummy.wso2.np.service.location;

import com.psl.wso2_dummy.wso2.np.client.NpBackendApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import psl.np.dataModel.dto.NotificationDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import psl.np.common.error.NpException;
import psl.np.common.restClient.NpRestClient;
import com.psl.wso2_dummy.wso2.np.client.api.NpBackendApiService;

@Service
public class LocationServiceImpl implements LocationService {
    public static final Logger logger = LogManager.getLogger(LocationServiceImpl.class);

    private final NpBackendApi npBackendApi;

    @Autowired
    public LocationServiceImpl(NpBackendApi npBackendApi) {
        this.npBackendApi = npBackendApi;
    }

    @Override
    public void postLocationDataToNpBackend(NotificationDto notificationDto) throws NpException {

        logger.info("NP-Backend called for saving Location Data");
        System.out.println(Thread.currentThread().getName());

        this.npBackendApi.postLocationDataToNpBackend(notificationDto);
    }
}
