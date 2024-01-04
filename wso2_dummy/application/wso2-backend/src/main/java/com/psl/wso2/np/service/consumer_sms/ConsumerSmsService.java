package com.psl.wso2.np.service.consumer_sms;

import com.psl.wso2.np.dto.formatted_dto.producer_obj.SmsRequestQueueFormattedDto;

public interface ConsumerSmsService {
    void processConsumedSms(SmsRequestQueueFormattedDto smsRequestQueueFormattedDto);
}
