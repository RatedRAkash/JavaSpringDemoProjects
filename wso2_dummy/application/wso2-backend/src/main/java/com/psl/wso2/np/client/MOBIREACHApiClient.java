package com.psl.wso2.np.client;

import com.psl.wso2.np.client.api.MOBIREACHApiService;
import com.psl.wso2.np.dto.response.MobireachResponseDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import psl.np.common.error.NpException;
import psl.np.common.error.NpServiceCallException;
import psl.np.common.error.NpTimeOutException;
import psl.np.common.restClient.ClientHelper;
import psl.np.dataModel.dto.error.ErrorDto;
import retrofit2.Response;
import java.io.IOException;
import java.net.SocketTimeoutException;

import static psl.np.common.utils.NpUtils.deserializeErrorDto;
import static psl.np.common.utils.NpUtils.processBaseUrl;

@Component
public class MOBIREACHApiClient {
    private static final Logger logger = LogManager.getLogger(MOBIREACHApiClient.class);
    private MOBIREACHApiService mobireachApiService;

    public MOBIREACHApiClient() {

    }

    public MOBIREACHApiClient createClient(String baseUrl) {
        //TODO hala madrid: Change BASEURL+Response DataType
        this.mobireachApiService = ClientHelper.buildClient(MOBIREACHApiService.class,
                processBaseUrl(baseUrl), 200);

        return this;
    }

    public Response<MobireachResponseDto> sendSms(String pathUrl, String username, String password, String smsMask, String mobile, String message)
            throws NpException {

        Response<MobireachResponseDto> response = null;
        try {
            logger.info("Calling MOBIREACHApiService service for: sendSms()");
            response = this.mobireachApiService.sendSms(pathUrl, username, password, smsMask, mobile, message)
                    .execute();
        } catch (SocketTimeoutException ex) {
            logger.error("Calling service timeout", ex);
            throw new NpTimeOutException();
        } catch (IOException ex) {
            logger.error("Unable to call Service", ex);
            throw new NpServiceCallException();
        }
        logger.info("MOBIREACHApiService Api response: " + response.code());
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
        return response;
    }
}