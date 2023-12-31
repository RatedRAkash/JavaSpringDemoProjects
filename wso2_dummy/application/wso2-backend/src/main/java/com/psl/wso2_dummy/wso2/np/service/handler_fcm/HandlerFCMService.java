package com.psl.wso2_dummy.wso2.np.service.handler_fcm;

import com.psl.wso2_dummy.wso2.np.dto.formatted_dto.PushTemplateFormattedDto;

public interface HandlerFCMService {
    void processMessageForSendingToFCMService(PushTemplateFormattedDto pushTemplateFormattedDto);
}