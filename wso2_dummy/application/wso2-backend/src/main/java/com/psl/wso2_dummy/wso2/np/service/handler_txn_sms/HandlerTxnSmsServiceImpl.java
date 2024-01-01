package com.psl.wso2_dummy.wso2.np.service.handler_txn_sms;

import com.psl.wso2_dummy.wso2.np.constant.EnumConstant.*;
import com.psl.wso2_dummy.wso2.np.dto.entity_projection.SmsTemplateProjection;
import com.psl.wso2_dummy.wso2.np.dto.formatted_dto.PushTemplateFormattedDto;
import com.psl.wso2_dummy.wso2.np.service.get_sms_template.GetSmsTemplateService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class HandlerTxnSmsServiceImpl implements HandlerTxnSmsService {
    private static final Logger logger = LogManager.getLogger(HandlerTxnSmsServiceImpl.class);

    private GetSmsTemplateService getSmsTemplateService;

    @Autowired
    public HandlerTxnSmsServiceImpl(GetSmsTemplateService getSmsTemplateService) {
        this.getSmsTemplateService = getSmsTemplateService;
    }

    @Override
    public void processMessageForSenderSms(PushTemplateFormattedDto pushTemplateFormattedDto) {
        logger.info("Processing Message for SenderSms: " + pushTemplateFormattedDto.toString());

        TransactionType uri_var_TXN_TYPE = pushTemplateFormattedDto.getEventOrigin().getTxnType();
        EventType EVENT = pushTemplateFormattedDto.getEventType();
        if(EVENT.equals(EventType.TRANSACTION)){
            logger.info("EventType is: " + EVENT);
        }
        else{
            logger.info("EventType is: " + EVENT);
            return; //NON_TXN sms will Not Get Sms
        }

        SmsTemplateProjection smsTemplateProjection = getSmsTemplateService.getSmsTemplateQuery(uri_var_TXN_TYPE.toString());

        if (smsTemplateProjection != null) {
            String FROM_BODY = smsTemplateProjection.getFromBody();
            String TO_BODY = smsTemplateProjection.getToBody();

            switch (uri_var_TXN_TYPE) {
                case BILL_PAYMENT:
                    //TODO hala madrid:
                    //TODO TimeFormatter <class name="com.progoti.nobopay.TimeFormatter"/>========================
                    BigDecimal AMOUNT = pushTemplateFormattedDto.getEventOrigin().getAmount();

                    break;

                case CASH_IN_FROM_BANK:
                    break;

                case CASH_IN_FROM_CARD:
                    break;

                case CASH_OUT_TO_BANK:
                    break;

                case MOBILE_RECHARGE:
                    break;

                case PAYMENT:
                    break;

                case SEND_MONEY:
                    break;

                case IDTP_SEND_MONEY:
                case IDTP_PAYMENT:
                case IDTP_RTP_SEND_MONEY:
                case IDTP_RTP_PAYMENT:
                    break;


                case IDTP_FUND_TRANSFER:
                    break;

                case CASHBACK:
                    break;

                default:
                    break;
            }
        }
        else{
            logger.info("No SmsTemplateProjection found for: " + uri_var_TXN_TYPE.toString());
        }
    }
}
