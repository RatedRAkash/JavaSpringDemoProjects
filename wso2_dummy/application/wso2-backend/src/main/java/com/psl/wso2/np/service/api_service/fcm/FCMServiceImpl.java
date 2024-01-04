package com.psl.wso2.np.service.api_service.fcm;

import com.psl.wso2.np.client.FCMApiClient;
import com.psl.wso2.np.dto.formatted_dto.PushTemplateFormattedDto;
import com.psl.wso2.np.dto.response.FCMResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import psl.np.common.error.NpException;

@Service
public class FCMServiceImpl implements FCMService{

    private final FCMApiClient fcmApiClient;

    @Autowired
    public FCMServiceImpl(FCMApiClient fcmApiClient) {
        this.fcmApiClient = fcmApiClient;
    }
    @Override
    public FCMResponseDto send(PushTemplateFormattedDto pushTemplateFormattedDto, String fcmToken) throws NpException {
        return this.fcmApiClient.sendMessageToFCM(pushTemplateFormattedDto, fcmToken);
    }
}
