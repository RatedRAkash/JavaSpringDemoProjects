package com.psl.wso2_dummy.wso2.np.service.get_sms_template;

import com.psl.wso2_dummy.wso2.np.dto.entity_projection.SmsTemplateProjection;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GetSmsTemplateService {
    SmsTemplateProjection getSmsTemplateQuery(String uri_var_TXN_TYPE);
    SmsTemplateProjection smsTemplateByCodeQuery(Integer errorCode);
}
