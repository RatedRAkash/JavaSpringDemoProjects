package com.psl.wso2_dummy.wso2.np.client;

import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Component;

import org.apache.logging.log4j.Logger;
import psl.np.common.error.NpException;
import psl.np.common.error.NpServiceCallException;
import psl.np.common.error.NpTimeOutException;
import psl.np.common.restClient.ClientHelper;
import com.psl.wso2_dummy.wso2.np.client.api.NpBackendApiService;
import psl.np.dataModel.dto.NotificationDto;
import psl.np.dataModel.dto.error.ErrorDto;
import retrofit2.Response;

import java.io.IOException;
import java.net.SocketTimeoutException;

import static psl.np.common.utils.NpUtils.deserializeErrorDto;
import static psl.np.common.utils.NpUtils.processBaseUrl;

@Component
public class NpBackendApi {
    private static final Logger logger = LogManager.getLogger(NpBackendApi.class);

    private final NpBackendApiService npBackendApiService;

    public NpBackendApi() {
        //TODO hala madrid: Change BASEURL+Response DataType
        this.npBackendApiService = ClientHelper.buildClient(NpBackendApiService.class, processBaseUrl("http://localhost:8080/nobopay-backend/"), 200);
    }


    public Void postLocationDataToNpBackend(NotificationDto notificationDto)
            throws NpException {
        Response<Void> response = null;
        try {
            logger.info("Calling npBackendApiService service for: saveLocationData()");
            response = this.npBackendApiService.saveLocationData(notificationDto).execute();
        } catch (SocketTimeoutException ex) {
            logger.error("Calling service timeout", ex);
            throw new NpTimeOutException();
        } catch (IOException ex) {
            logger.error("Unable to call Service", ex);
            throw new NpServiceCallException();
        }
        logger.info("NpBackendApiService Api response: " + response.code());
        if (!response.isSuccessful()) {
            ErrorDto errorDto;
            try {
                errorDto = deserializeErrorDto(response.errorBody());
            } catch (IOException ex) {
                logger.error("Unable to read error body", ex);
                throw new NpServiceCallException();
            }
            throw new NpException(response.code(), errorDto);
        }
        return response.body();
    }


}
