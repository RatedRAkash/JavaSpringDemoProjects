package com.psl.wso2.np.service.handler_txn_sms;

import com.psl.wso2.np.client.NpBackendApiClient;
import com.psl.wso2.np.dto.formatted_dto.producer_obj.SmsRequestQueueFormattedDto;
import com.psl.wso2.np.dto.response.BankInfoResponseDto;
import com.psl.wso2.np.service.get_sms_template.GetSmsTemplateService;
import com.psl.wso2.np.constant.EnumConstant.*;
import com.psl.wso2.np.dto.entity_projection.SmsTemplateProjection;
import com.psl.wso2.np.dto.formatted_dto.PushTemplateFormattedDto;
import com.psl.wso2.np.service.sender_sms.SenderSmsService;
import com.psl.wso2.np.util.TimeFormatter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import psl.np.common.error.NpException;

import java.math.BigDecimal;
import java.util.List;

@Service
public class HandlerTxnSmsServiceImpl implements HandlerTxnSmsService {
    private static final Logger logger = LogManager.getLogger(HandlerTxnSmsServiceImpl.class);

    private NpBackendApiClient npBackendApiClient;
    private GetSmsTemplateService getSmsTemplateService;
    private SenderSmsService senderSmsService;


    @Autowired
    public HandlerTxnSmsServiceImpl(NpBackendApiClient npBackendApiClient, GetSmsTemplateService getSmsTemplateService, SenderSmsService senderSmsService) {
        this.npBackendApiClient = npBackendApiClient;
        this.getSmsTemplateService = getSmsTemplateService;
        this.senderSmsService = senderSmsService;
    }

    @Override
    public void processMessageForSenderSms(PushTemplateFormattedDto pushTemplateFormattedDto) {
        logger.info("Processing Message for SenderSms: " + pushTemplateFormattedDto.toString());

        TransactionType uri_var_TXN_TYPE = pushTemplateFormattedDto.getEventOrigin().getTxnType();
        EventType EVENT = pushTemplateFormattedDto.getEventType();
        if(EVENT.equals(EventType.TRANSACTION)) {
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

            BigDecimal AMOUNT;
            String TIME, OUTPUT_DATE, TXN_ID="", REFERENCE, FROM_ACCOUNT, TO_ACCOUNT, BANK_ACCOUNT;
            String uri_var_BANK_CODE, BANK; //CASH_IN_FROM_BANK
            String ACCOUNT, CARD_TYPE; //CASH_IN_FROM_CARD
            String STATUS, MOBILE, OPERATOR; //MOBILE_RECHARGE
            String OFFER_MSG; //CASHBACK

            switch (uri_var_TXN_TYPE) {
                case BILL_PAYMENT:
                    AMOUNT = pushTemplateFormattedDto.getEventOrigin().getAmount();

                    TIME = pushTemplateFormattedDto.getEventOrigin().getTxnTime();
                    OUTPUT_DATE = TimeFormatter.formatDate(TIME);

                    TXN_ID = pushTemplateFormattedDto.getEventOrigin().getTxnId();
                    REFERENCE = "";
                    FROM_ACCOUNT = pushTemplateFormattedDto.getEventOrigin().getFromAccount();
                    TO_ACCOUNT = pushTemplateFormattedDto.getEventOrigin().getToAccount();

                    if(!(FROM_BODY.equals(null)) & !(FROM_BODY.equals(""))) {
                        FROM_BODY = UtilHandlerTxnSms.formatSmsBody_BILL_PAYMENT_to_account(FROM_BODY, AMOUNT, TO_ACCOUNT, TXN_ID, REFERENCE, OUTPUT_DATE);
                        senderSmsService.sendMessageToProducerSenderSms(new SmsRequestQueueFormattedDto(EVENT, FROM_ACCOUNT, FROM_BODY));
                    }

                    if(!(TO_BODY.equals(null)) & !(TO_BODY.equals(""))) {
                        TO_BODY = UtilHandlerTxnSms.formatSmsBody_BILL_PAYMENT_from_account(TO_BODY, AMOUNT, FROM_ACCOUNT, TXN_ID, REFERENCE, OUTPUT_DATE);
                        senderSmsService.sendMessageToProducerSenderSms(new SmsRequestQueueFormattedDto(EVENT, TO_ACCOUNT, TO_BODY));
                    }
                    break;

                case CASH_IN_FROM_BANK:
                    if(pushTemplateFormattedDto.getEventOrigin().getStatus().equals("FAILED")){
                        logger.info("eventOrigin.status is: " + pushTemplateFormattedDto.getEventOrigin().getStatus());
                        return;
                    }

                    AMOUNT = pushTemplateFormattedDto.getEventOrigin().getAmount();

                    TIME = pushTemplateFormattedDto.getEventOrigin().getTxnTime();
                    OUTPUT_DATE = TimeFormatter.formatDate(TIME);

                    TXN_ID = pushTemplateFormattedDto.getEventOrigin().getTxnId();
                    BANK_ACCOUNT = pushTemplateFormattedDto.getEventOrigin().getAccountNumber();

                    uri_var_BANK_CODE = pushTemplateFormattedDto.getEventOrigin().getBankSwiftCode();
                    TO_ACCOUNT = pushTemplateFormattedDto.getEventOrigin().getToAccount();


                    //<http method="GET" uri-template="http://localhost:8280/services/api/bank-info?bankCode={uri.var.BANK_CODE}"/>
                    logger.info("NP-Backend called for getting Bank-Info");
                    try {
                        List<BankInfoResponseDto> bankInfoResponseDtoList = this.npBackendApiClient.callBankInfoApi();
                        BankInfoResponseDto bankInfo = null;
                        for(BankInfoResponseDto bankInfoResponseDto: bankInfoResponseDtoList) {
                            if(bankInfoResponseDto.getSwiftCode().equals(uri_var_BANK_CODE)) {
                                bankInfo = bankInfoResponseDto;

                                break;
                            }
                        }
                        BANK = bankInfo.getBankName();

                        if(!(FROM_BODY.equals(null)) & !(FROM_BODY.equals(""))) {
                            FROM_BODY = UtilHandlerTxnSms.formatSmsBody_CASH_IN_FROM_BANK(FROM_BODY, AMOUNT, BANK_ACCOUNT, BANK, TXN_ID, OUTPUT_DATE);
                            senderSmsService.sendMessageToProducerSenderSms(new SmsRequestQueueFormattedDto(EVENT, TO_ACCOUNT, FROM_BODY));
                        }

                    } catch (NpException e) {
                        logger.info("NP-Backend couldn't fetch Bank-Info");
//                        e.printStackTrace(); //TODO: Uncomment printStackTrace after testing is done
                        //TODO: GetBankInfo.xml ERROR_CODE = 500
                    }

                    break;

                case CASH_IN_FROM_CARD:
                    AMOUNT = pushTemplateFormattedDto.getEventOrigin().getAmount();

                    TIME = pushTemplateFormattedDto.getEventOrigin().getTxnTime();
                    OUTPUT_DATE = TimeFormatter.formatDate(TIME);

                    TXN_ID = pushTemplateFormattedDto.getEventOrigin().getTxnId();
                    ACCOUNT = pushTemplateFormattedDto.getEventOrigin().getExternalData();
                    CARD_TYPE = pushTemplateFormattedDto.getEventOrigin().getExternalIdentifier();
                    TO_ACCOUNT = pushTemplateFormattedDto.getEventOrigin().getToAccount();

                    if(!(FROM_BODY.equals(null)) & !(FROM_BODY.equals(""))) {
                        FROM_BODY = UtilHandlerTxnSms.formatSmsBody_CASH_IN_FROM_CARD(FROM_BODY, AMOUNT, CARD_TYPE, ACCOUNT, TXN_ID, OUTPUT_DATE);
                        senderSmsService.sendMessageToProducerSenderSms(new SmsRequestQueueFormattedDto(EVENT, TO_ACCOUNT, FROM_BODY));
                    }

                    break;

                case CASH_OUT_TO_BANK:
                    if(pushTemplateFormattedDto.getEventPublisher()!=null){
                        if(pushTemplateFormattedDto.getEventPublisher().equals("SCHEDULER")){
                            logger.info("eventPublisher is: " + pushTemplateFormattedDto.getEventPublisher() + ", So dropping message");
                            return;
                        }
                    }
                    if(pushTemplateFormattedDto.getEventOrigin().getStatus().equals("FAILED")){
                        logger.info("eventOrigin.status is: " + pushTemplateFormattedDto.getEventOrigin().getStatus());
                        return;
                    }

                    AMOUNT = pushTemplateFormattedDto.getEventOrigin().getAmount();

                    TIME = pushTemplateFormattedDto.getEventOrigin().getTxnTime();
                    OUTPUT_DATE = TimeFormatter.formatDate(TIME);

                    TXN_ID = pushTemplateFormattedDto.getEventOrigin().getTxnId();
                    BANK_ACCOUNT = pushTemplateFormattedDto.getEventOrigin().getAccountNumber();
                    uri_var_BANK_CODE = pushTemplateFormattedDto.getEventOrigin().getBankSwiftCode();
                    FROM_ACCOUNT = pushTemplateFormattedDto.getEventOrigin().getFromAccount();

                    //<http method="GET" uri-template="http://localhost:8280/services/api/bank-info?bankCode={uri.var.BANK_CODE}"/>
                    logger.info("NP-Backend called for getting Bank-Info");
                    try {
                        List<BankInfoResponseDto> bankInfoResponseDtoList = this.npBackendApiClient.callBankInfoApi();
                        BankInfoResponseDto bankInfo = null;
                        for(BankInfoResponseDto bankInfoResponseDto: bankInfoResponseDtoList) {
                            if(bankInfoResponseDto.getSwiftCode().equals(uri_var_BANK_CODE)) {
                                bankInfo = bankInfoResponseDto;

                                break;
                            }
                        }
                        BANK = bankInfo.getBankName();


                        if(!(FROM_BODY.equals(null)) & !(FROM_BODY.equals(""))) {
                            FROM_BODY = UtilHandlerTxnSms.formatSmsBody_CASH_OUT_TO_BANK(FROM_BODY, AMOUNT, BANK_ACCOUNT, BANK, TXN_ID, OUTPUT_DATE);
                            senderSmsService.sendMessageToProducerSenderSms(new SmsRequestQueueFormattedDto(EVENT, FROM_ACCOUNT, FROM_BODY));
                        }

                    } catch (NpException e) {
                        logger.info("NP-Backend couldn't fetch Bank-Info");
//                        e.printStackTrace(); //TODO: Uncomment printStackTrace after testing is done
                        //TODO: GetBankInfo.xml ERROR_CODE = 500
                    }

                    break;

                case MOBILE_RECHARGE:
                    if(pushTemplateFormattedDto.getEventOrigin().getStatus().equals("FAILED")){
                        logger.info("eventOrigin.status is: " + pushTemplateFormattedDto.getEventOrigin().getStatus());
                        return;
                    }

                    STATUS = pushTemplateFormattedDto.getEventOrigin().getStatus();
                    AMOUNT = pushTemplateFormattedDto.getEventOrigin().getAmount();

                    TIME = pushTemplateFormattedDto.getEventOrigin().getTxnTime();
                    OUTPUT_DATE = TimeFormatter.formatDate(TIME);

                    TXN_ID = pushTemplateFormattedDto.getEventOrigin().getTxnId();
                    MOBILE = pushTemplateFormattedDto.getEventOrigin().getMobileNo();

                    OPERATOR = pushTemplateFormattedDto.getEventOrigin().getOperator();
                    FROM_ACCOUNT = pushTemplateFormattedDto.getEventOrigin().getFromAccount();

                    if(STATUS.equals("COMPLETE")){
                        if(!(FROM_BODY.equals(null)) & !(FROM_BODY.equals(""))) {
                            FROM_BODY = UtilHandlerTxnSms.formatSmsBody_MOBILE_RECHARGE(FROM_BODY, AMOUNT, OPERATOR, MOBILE, TXN_ID, OUTPUT_DATE);
                            senderSmsService.sendMessageToProducerSenderSms(new SmsRequestQueueFormattedDto(EVENT, FROM_ACCOUNT, FROM_BODY));
                        }
                    }
                    else{
                        logger.info("eventOrigin.status is: " + STATUS);
                        return;
                    }

                    break;

                case PAYMENT:
                    AMOUNT = pushTemplateFormattedDto.getEventOrigin().getAmount();

                    TIME = pushTemplateFormattedDto.getEventOrigin().getTxnTime();
                    OUTPUT_DATE = TimeFormatter.formatDate(TIME);

                    TXN_ID = pushTemplateFormattedDto.getEventOrigin().getTxnId();
                    FROM_ACCOUNT = pushTemplateFormattedDto.getEventOrigin().getFromAccount();
                    TO_ACCOUNT = pushTemplateFormattedDto.getEventOrigin().getToAccount();

                    if (!(FROM_BODY.equals(null)) & !(FROM_BODY.equals(""))) {
                        FROM_BODY = UtilHandlerTxnSms.formatSmsBody_PAYMENT_to_account(FROM_BODY, AMOUNT, TO_ACCOUNT, TXN_ID, OUTPUT_DATE);
                        senderSmsService.sendMessageToProducerSenderSms(new SmsRequestQueueFormattedDto(EVENT, FROM_ACCOUNT, FROM_BODY));
                    }

                    if (!(TO_BODY.equals(null)) & !(TO_BODY.equals(""))) {
                        TO_BODY = UtilHandlerTxnSms.formatSmsBody_PAYMENT_from_account(TO_BODY, AMOUNT, FROM_ACCOUNT, TXN_ID, OUTPUT_DATE);
                        senderSmsService.sendMessageToProducerSenderSms(new SmsRequestQueueFormattedDto(EVENT, TO_ACCOUNT, TO_BODY));
                    }
                    break;



                case SEND_MONEY:
                    AMOUNT = pushTemplateFormattedDto.getEventOrigin().getAmount();

                    TIME = pushTemplateFormattedDto.getEventOrigin().getTxnTime();
                    OUTPUT_DATE = TimeFormatter.formatDate(TIME);

                    TXN_ID = pushTemplateFormattedDto.getEventOrigin().getTxnId();
                    FROM_ACCOUNT = pushTemplateFormattedDto.getEventOrigin().getFromAccount();
                    TO_ACCOUNT = pushTemplateFormattedDto.getEventOrigin().getToAccount();

                    if (!(FROM_BODY.equals(null)) & !(FROM_BODY.equals(""))) {
                        FROM_BODY = UtilHandlerTxnSms.formatSmsBody_SEND_MONEY_to_account(FROM_BODY, AMOUNT, TO_ACCOUNT, TXN_ID, OUTPUT_DATE);
                        senderSmsService.sendMessageToProducerSenderSms(new SmsRequestQueueFormattedDto(EVENT, FROM_ACCOUNT, FROM_BODY));
                    }

                    if (!(TO_BODY.equals(null)) & !(TO_BODY.equals(""))) {
                        TO_BODY = UtilHandlerTxnSms.formatSmsBody_SEND_MONEY_from_account(TO_BODY, AMOUNT, FROM_ACCOUNT, TXN_ID, OUTPUT_DATE);
                        senderSmsService.sendMessageToProducerSenderSms(new SmsRequestQueueFormattedDto(EVENT, TO_ACCOUNT, TO_BODY));
                    }

                    break;

                case IDTP_SEND_MONEY:
                case IDTP_PAYMENT:
                case IDTP_RTP_SEND_MONEY:
                case IDTP_RTP_PAYMENT:
                    if(pushTemplateFormattedDto.getEventOrigin().getStatus().equals("FAILED")){
                        logger.info("eventOrigin.status is: " + pushTemplateFormattedDto.getEventOrigin().getStatus());
                        return;
                    }
                    AMOUNT = pushTemplateFormattedDto.getEventOrigin().getAmount();

                    TIME = pushTemplateFormattedDto.getEventOrigin().getTxnTime();
                    OUTPUT_DATE = TimeFormatter.formatDate(TIME);

                    TXN_ID = pushTemplateFormattedDto.getEventOrigin().getTxnId();
                    FROM_ACCOUNT = pushTemplateFormattedDto.getEventOrigin().getFromAccount();
                    TO_ACCOUNT = pushTemplateFormattedDto.getEventOrigin().getToAccount();

                    if (!(FROM_BODY.equals(null)) & !(FROM_BODY.equals(""))) {
                        FROM_BODY = UtilHandlerTxnSms.formatSmsBody_IDTP_SENDMONEY_PAYMENT_RTP_SENDMONEY_RTP_PAYMENT(FROM_BODY, AMOUNT, TXN_ID, OUTPUT_DATE);
                        senderSmsService.sendMessageToProducerSenderSms(new SmsRequestQueueFormattedDto(EVENT, FROM_ACCOUNT, FROM_BODY));
                    }

                    break;

                case IDTP_FUND_TRANSFER:
                    if(pushTemplateFormattedDto.getEventOrigin().getStatus().equals("FAILED")){
                        logger.info("eventOrigin.status is: " + pushTemplateFormattedDto.getEventOrigin().getStatus());
                        return;
                    }
                    AMOUNT = pushTemplateFormattedDto.getEventOrigin().getAmount();

                    TIME = pushTemplateFormattedDto.getEventOrigin().getTxnTime();
                    OUTPUT_DATE = TimeFormatter.formatDate(TIME);

                    TXN_ID = pushTemplateFormattedDto.getEventOrigin().getTxnId();
                    FROM_ACCOUNT = pushTemplateFormattedDto.getEventOrigin().getFromAccount();
                    TO_ACCOUNT = pushTemplateFormattedDto.getEventOrigin().getToAccount();
                    if (!(TO_BODY.equals(null)) & !(TO_BODY.equals(""))) {
                        TO_BODY = UtilHandlerTxnSms.formatSmsBody_IDTP_FUND_TRANSFER(TO_BODY, AMOUNT, TXN_ID, OUTPUT_DATE);
                        senderSmsService.sendMessageToProducerSenderSms(new SmsRequestQueueFormattedDto(EVENT, TO_ACCOUNT, TO_BODY));
                    }
                    break;

                case CASHBACK:
                    AMOUNT = pushTemplateFormattedDto.getEventOrigin().getAmount();

                    TIME = pushTemplateFormattedDto.getEventOrigin().getTxnTime();
                    OUTPUT_DATE = TimeFormatter.formatDate(TIME);

                    TXN_ID = pushTemplateFormattedDto.getEventOrigin().getTxnId();
                    FROM_ACCOUNT = pushTemplateFormattedDto.getEventOrigin().getFromAccount();
                    TO_ACCOUNT = pushTemplateFormattedDto.getEventOrigin().getToAccount();
                    OFFER_MSG = pushTemplateFormattedDto.getEventOrigin().getOfferMessage().getOfferMsg().getSmsBody();

                    senderSmsService.sendMessageToProducerSenderSms(new SmsRequestQueueFormattedDto(EVENT, TO_ACCOUNT, OFFER_MSG));

                    break;

                default:
                    logger.info("ESB FAULT IN TXN SMS HANDLER for TxnType: " + pushTemplateFormattedDto.getEventOrigin().getTxnType());
                    break;
            }
        }
        else{
            logger.info("No SmsTemplateProjection found for: " + uri_var_TXN_TYPE.toString());
        }
    }
}
