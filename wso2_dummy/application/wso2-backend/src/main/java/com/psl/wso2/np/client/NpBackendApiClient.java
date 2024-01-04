package com.psl.wso2.np.client;

import com.psl.wso2.np.client.api.NpBackendApiService;
import com.psl.wso2.np.constant.ConfigConstant;
import com.psl.wso2.np.dto.NotificationDto;
import com.psl.wso2.np.dto.response.BankInfoResponseDto;
import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Component;

import org.apache.logging.log4j.Logger;
import psl.np.common.error.NpException;
import psl.np.common.error.NpServiceCallException;
import psl.np.common.error.NpTimeOutException;
import psl.np.common.restClient.ClientHelper;
import psl.np.dataModel.dto.error.ErrorDto;
import retrofit2.Response;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.List;

import static psl.np.common.utils.NpUtils.deserializeErrorDto;
import static psl.np.common.utils.NpUtils.processBaseUrl;

@Component
public class NpBackendApiClient {
    private static final Logger logger = LogManager.getLogger(NpBackendApiClient.class);

    private final NpBackendApiService npBackendApiService;

    public NpBackendApiClient() {
        //TODO hala madrid: Change BASEURL+Response DataType
        this.npBackendApiService = ClientHelper.buildClient(NpBackendApiService.class,
                processBaseUrl(ConfigConstant.Backend_Url), 200);
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

    public List<BankInfoResponseDto> callBankInfoApi()
            throws NpException {
        Response<List<BankInfoResponseDto>> response = null;
        try {
            logger.info("Calling npBackendApiService service for: getBankInfo()");
            response = this.npBackendApiService.getBankInfo().execute();
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
