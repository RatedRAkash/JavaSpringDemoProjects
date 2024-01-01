package com.psl.wso2_dummy.wso2.np.service.get_sms_template;

import com.psl.wso2_dummy.wso2.np.dto.entity_projection.SmsTemplateProjection;
import com.psl.wso2_dummy.wso2.np.repository.SmsTemplateRepository;
import com.psl.wso2_dummy.wso2.np.service.handler_txn_sms.HandlerTxnSmsServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetSmsTemplateServiceImpl implements GetSmsTemplateService {

    private static final Logger logger = LogManager.getLogger(GetSmsTemplateServiceImpl.class);

    private SmsTemplateRepository smsTemplateRepository;

    @Autowired
    public GetSmsTemplateServiceImpl(SmsTemplateRepository smsTemplateRepository) {
        this.smsTemplateRepository = smsTemplateRepository;
    }

    @Override
    public SmsTemplateProjection getSmsTemplateQuery(String uri_var_TXN_TYPE) {
        List<SmsTemplateProjection> smsTemplateProjectionList = smsTemplateRepository.smsTemplateQuery(uri_var_TXN_TYPE);

        SmsTemplateProjection smsTemplateProjection = null;

        if(!smsTemplateProjectionList.isEmpty()) {
            smsTemplateProjection = formatSmsTemplateProjectionObject(smsTemplateProjectionList.get(0));
        }
        else{
            logger.info("No SmsTemplate found for TxnType: " + uri_var_TXN_TYPE.toString());
        }

        return smsTemplateProjection; //can be returned as NULL, so the caller need to Handle it
    }

    @Override
    public SmsTemplateProjection smsTemplateByCodeQuery(Integer errorCode) {
        List<SmsTemplateProjection> smsTemplateProjectionList = smsTemplateRepository.smsTemplateByCodeQuery(errorCode);

        SmsTemplateProjection smsTemplateProjection = null;

        if(!smsTemplateProjectionList.isEmpty()) {
            smsTemplateProjection = formatSmsTemplateProjectionObject(smsTemplateProjectionList.get(0));
        }
        else{
            logger.info("No SmsTemplate found for ErrorCode: " + errorCode.toString());
        }

        return smsTemplateProjection; //can be returned as NULL, so the caller need to Handle it
    }

    private static SmsTemplateProjection formatSmsTemplateProjectionObject(SmsTemplateProjection smsTemplateProjection) {
        String FROM_BODY = null;
        String TO_BODY = null;

        Boolean FROM_SMS = smsTemplateProjection.getSenderSms();
        Boolean TO_SMS = smsTemplateProjection.getRecieverSms();

        if (FROM_SMS) {
            FROM_BODY = smsTemplateProjection.getFromBody();
        } else {
            FROM_BODY = "";
        }

        if (TO_SMS) {
            TO_BODY = smsTemplateProjection.getToBody();
        } else {
            TO_BODY = "";
        }

        SmsTemplateProjection smsTemplateProjectionNew = new SmsTemplateProjection();
        smsTemplateProjectionNew.setFromBody(FROM_BODY);
        smsTemplateProjectionNew.setFromBody(TO_BODY);
        smsTemplateProjectionNew.setRecieverSms(smsTemplateProjection.getRecieverSms());
        smsTemplateProjectionNew.setSenderSms(smsTemplateProjection.getSenderSms());

        return smsTemplateProjectionNew;
    }
}
