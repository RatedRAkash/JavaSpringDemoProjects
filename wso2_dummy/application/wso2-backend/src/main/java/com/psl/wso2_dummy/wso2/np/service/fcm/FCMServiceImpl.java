package com.psl.wso2_dummy.wso2.np.service.fcm;

import com.psl.wso2_dummy.wso2.np.client.FCMApi;
import com.psl.wso2_dummy.wso2.np.dto.formatted_dto.PushTemplateFormattedDto;
import com.psl.wso2_dummy.wso2.np.dto.response.FCMResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import psl.np.common.error.NpException;

@Service
public class FCMServiceImpl implements FCMService{

    private final FCMApi fcmApi;

    @Autowired
    public FCMServiceImpl(FCMApi fcmApi) {
        this.fcmApi = fcmApi;
    }
    @Override
    public FCMResponseDto send(PushTemplateFormattedDto pushTemplateFormattedDto, String fcmToken) throws NpException {
        return this.fcmApi.sendMessageToFCM(pushTemplateFormattedDto, fcmToken);
    }
}
