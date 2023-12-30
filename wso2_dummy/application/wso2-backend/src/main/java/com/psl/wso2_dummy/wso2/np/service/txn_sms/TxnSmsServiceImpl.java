package com.psl.wso2_dummy.wso2.np.service.txn_sms;

import com.psl.wso2_dummy.wso2.np.constant.EnumConstant.*;
import com.psl.wso2_dummy.wso2.np.dto.PushTemplateFromattedDto;
import com.psl.wso2_dummy.wso2.np.entity.SmsTemplate;
import com.psl.wso2_dummy.wso2.np.repository.SmsTemplateRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TxnSmsServiceImpl implements TxnSmsService {
    private static final Logger logger = LogManager.getLogger(TxnSmsServiceImpl.class);

    private SmsTemplateRepository smsTemplateRepository;

    @Autowired
    public TxnSmsServiceImpl(SmsTemplateRepository smsTemplateRepository) {
        this.smsTemplateRepository = smsTemplateRepository;
    }

    @Override
    public void processMessageForSenderSms(PushTemplateFromattedDto pushTemplateFromattedDto) {
        logger.info("Processing Message for SenderSms: " + pushTemplateFromattedDto.toString());

        TransactionType uri_var_TXN_TYPE = pushTemplateFromattedDto.getEventOrigin().getTxnType();
        EventType EVENT = pushTemplateFromattedDto.getEventType();

        List<SmsTemplate> smsTemplateList = smsTemplateRepository.smsTemplateQuery(uri_var_TXN_TYPE.toString());

        //TODO GetSmsTemplate er ($.data.senderSms), ($.data.recieverSms) ========================

        if(smsTemplateList.size() > 0){
            String FROM_BODY = smsTemplateList.get(0).getFromBody();
            String TO_BODY = smsTemplateList.get(0).getToBody();

            switch (uri_var_TXN_TYPE) {
                case BILL_PAYMENT:
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
    }
}
