package com.psl.wso2_dummy.wso2.np.service.txn_sms;

import com.psl.wso2_dummy.wso2.np.dto.PushTemplateFromattedDto;

public interface TxnSmsService {
    void processMessageForSenderSms(PushTemplateFromattedDto pushTemplateFromattedDto);
}
