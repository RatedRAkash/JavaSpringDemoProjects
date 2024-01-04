package com.psl.wso2.np.service.api_service.fcm;

import com.psl.wso2.np.dto.formatted_dto.PushTemplateFormattedDto;
import com.psl.wso2.np.dto.response.FCMResponseDto;
import psl.np.common.error.NpException;

public interface FCMService {
    FCMResponseDto send(PushTemplateFormattedDto pushTemplateFormattedDto, String fcmToken) throws NpException;
}
