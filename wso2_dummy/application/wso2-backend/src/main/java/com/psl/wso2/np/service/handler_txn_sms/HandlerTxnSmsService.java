package com.psl.wso2.np.service.handler_txn_sms;

import com.psl.wso2.np.dto.formatted_dto.PushTemplateFormattedDto;

public interface HandlerTxnSmsService {
    void processMessageForSenderSms(PushTemplateFormattedDto pushTemplateFormattedDto);
}
