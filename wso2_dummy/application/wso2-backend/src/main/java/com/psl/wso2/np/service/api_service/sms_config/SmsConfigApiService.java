package com.psl.wso2.np.service.api_service.sms_config;

import com.psl.wso2.np.dto.entity_projection.SmsVendorConfigProjection;
import com.psl.wso2.np.entity.SmsResponseLog;

public interface SmsConfigApiService {
    String getVendorIdentifierFromOperator(String mobile);

    SmsVendorConfigProjection getSmsVendorConfig(String identifier);

    SmsResponseLog saveSmsResponseLog(SmsResponseLog smsResponseLog);
}
