package com.psl.wso2.np.service.sender_sms;

import com.psl.wso2.np.dto.formatted_dto.producer_obj.SmsRequestQueueFormattedDto;

public interface SenderSmsService {
    void sendMessageToProducerSenderSms(SmsRequestQueueFormattedDto smsRequestQueueFormattedDto);
}
