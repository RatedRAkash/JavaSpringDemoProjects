package com.psl.wso2.np.client;

import com.psl.wso2.np.client.api.TallykhataApiService;
import com.psl.wso2.np.dto.request.TallykhataVendorRequestDto;
import com.psl.wso2.np.dto.response.TallykhataVendorResponseDto;
import okhttp3.Interceptor;
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

import static psl.np.common.utils.NpUtils.*;


@Component
public class TallykhataApiClient {
    private static final Logger logger = LogManager.getLogger(TallykhataApiClient.class);
    private TallykhataApiService tallykhataApiService;

    public TallykhataApiClient() {

    }

    public TallykhataApiClient createClient(String baseUrl, Interceptor... interceptors) {
        //TODO hala madrid: Change BASEURL+Response DataType
        this.tallykhataApiService = ClientHelper.buildClient(TallykhataApiService.class,
                processBaseUrl(baseUrl), 200, interceptors);

        return this;
    }

    public Response<TallykhataVendorResponseDto> sendSms(String pathUrl,TallykhataVendorRequestDto requestDto)
            throws NpException {

        Response<TallykhataVendorResponseDto> response = null;
        try {
            logger.info("Calling TallykhataApiService service for: sendSms()");
            response = this.tallykhataApiService.sendSms(pathUrl, requestDto)
                    .execute();
            response.body().setStatusText("SUCCESS");
            response.body().setSMSCount(1);

        } catch (SocketTimeoutException ex) {
            logger.error("Calling service timeout", ex);
            throw new NpTimeOutException();
        } catch (IOException ex) {
            logger.error("Unable to call Service", ex);
            throw new NpServiceCallException();
        }
        logger.info("TallykhataApiService Api response: " + response.code());
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