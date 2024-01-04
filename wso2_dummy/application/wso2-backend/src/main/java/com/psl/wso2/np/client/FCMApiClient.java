package com.psl.wso2.np.client;

import com.psl.wso2.np.client.api.FCMApiService;
import com.psl.wso2.np.dto.formatted_dto.PushTemplateFormattedDto;
import com.psl.wso2.np.dto.response.FCMResponseDto;
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
public class FCMApiClient {
    private static final Logger logger = LogManager.getLogger(FCMApiClient.class);
    private final FCMApiService fcmApiService;

    public FCMApiClient() {
        //TODO hala madrid: Change BASEURL+Response DataType
        this.fcmApiService = ClientHelper.buildClient(FCMApiService.class,
                processBaseUrl("https://fcm.googleapis.com/"), 200);
    }

    public FCMResponseDto sendMessageToFCM(PushTemplateFormattedDto pushTemplateFormattedDto, String fcmToken)
            throws NpException {
        Response<FCMResponseDto> response = null;
        try {
            logger.info("Calling fcmApiService service for: sendMessage()");
            response = this.fcmApiService.sendMessage(pushTemplateFormattedDto, fcmToken).execute();
        } catch (SocketTimeoutException ex) {
            logger.error("Calling service timeout", ex);
            throw new NpTimeOutException();
        } catch (IOException ex) {
            logger.error("Unable to call Service", ex);
            throw new NpServiceCallException();
        }
        logger.info("FCMApiService Api response: " + response.code());
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
