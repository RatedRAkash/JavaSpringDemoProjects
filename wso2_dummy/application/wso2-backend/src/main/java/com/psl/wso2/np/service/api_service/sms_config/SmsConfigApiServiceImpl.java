package com.psl.wso2.np.service.api_service.sms_config;

import com.psl.wso2.np.dto.entity_projection.SmsVendorConfigProjection;
import com.psl.wso2.np.entity.SmsResponseLog;
import com.psl.wso2.np.repository.SmsResponseLogRepository;
import com.psl.wso2.np.repository.SmsVendorConfigRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmsConfigApiServiceImpl implements SmsConfigApiService{

    private static final Logger logger = LogManager.getLogger(SmsConfigApiServiceImpl.class);
    private final SmsVendorConfigRepository smsVendorConfigRepository;
    private final SmsResponseLogRepository smsResponseLogRepository;

    @Autowired
    public SmsConfigApiServiceImpl(SmsVendorConfigRepository smsVendorConfigRepository, SmsResponseLogRepository smsResponseLogRepository) {
        this.smsVendorConfigRepository = smsVendorConfigRepository;
        this.smsResponseLogRepository = smsResponseLogRepository;
    }

    @Override
    public String getVendorIdentifierFromOperator(String mobile) {
        String uri_var_OPERATOR = UtilParseOperatorFromMobile.getParsedOperatorFromMobile(mobile).toString();

        List<String> vendorList = smsVendorConfigRepository.getVendorIdentifier(uri_var_OPERATOR);
        if(vendorList.size() > 0){
            return vendorList.get(0);
        }else {
            return null;
        }
    }

    @Override
    public SmsVendorConfigProjection getSmsVendorConfig(String identifier) {
        return smsVendorConfigRepository.getSmsConfig(identifier);
    }

    @Override
    public SmsResponseLog saveSmsResponseLog(SmsResponseLog smsResponseLog) {
        return smsResponseLogRepository.save(smsResponseLog);
    }


}
