package com.psl.wso2_dummy.wso2.np.service.txn_notification;

import com.psl.wso2_dummy.wso2.np.dto.NotificationDto;
import com.psl.wso2_dummy.wso2.np.repository.PushTemplateRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class TxnNotificationServiceImpl implements TxnNotificationService{
    private static final Logger logger = LogManager.getLogger(TxnNotificationServiceImpl.class);

    private PushTemplateRepository pushTemplateRepository;

    private String mobileNo;
    private String RECHARGE_MOBILE;
    private String TITLE;
    private String PUSH_BODY;

    public TxnNotificationServiceImpl(PushTemplateRepository pushTemplateRepository) {
        this.pushTemplateRepository = pushTemplateRepository;
    }

    @Override
    public void processMessageForPublisherNotification(NotificationDto notificationDto) {
        logger.info("processing message to sent to PublisherNotification");
        if(notificationDto.getShouldSendNotification()) {
            switch (notificationDto.getEventOrigin().getTxnType()) {

                case CASH_IN_FROM_CARD:
                case CASH_IN_FROM_MFS_WALLET:
                case CASH_IN_FROM_MFS_AGENT:
                case CASH_IN_FROM_BANK:
                case PAYMENT:
                case SEND_MONEY:
                case REVERSE_TRANSACTION:
                case CASH_IN_INITIATION:
                case IDTP_FUND_TRANSFER:
                case PROCESS_RTP:
                    this.mobileNo = notificationDto.getEventOrigin().getToAccount();
                    break;

                case CASH_OUT_TO_MFS_WALLET:
                case CASH_OUT_TO_BANK:
                case CASH_OUT_TO_MFS_AGENT:
                case BILL_PAYMENT:
                case CASH_OUT_INITIATION:
                case IDTP_PAYMENT:
                case IDTP_SEND_MONEY:
                case DECLINE_RTP:
                    this.mobileNo = notificationDto.getEventOrigin().getFromAccount();
                    break;

                case MOBILE_RECHARGE:
                    this.mobileNo = notificationDto.getEventOrigin().getFromAccount();
                    this.RECHARGE_MOBILE = notificationDto.getEventOrigin().getMobileNo();
                    break;

                case CASHBACK:
                    this.mobileNo = notificationDto.getEventOrigin().getToAccount();
                    this.TITLE = notificationDto.getEventOrigin().getOfferMessage().getOfferMsg().getPushTitle();
                    this.PUSH_BODY = notificationDto.getEventOrigin().getOfferMessage().getOfferMsg().getPushBody();
                    break;

                default:
                    logger.info("Unexpected value: " + notificationDto.getEventOrigin().getTxnType());

                pushTemplateRepository.wso2messageInfoQuery(notificationDto.getEventOrigin().getTxnType().toString());
            }
        } else {
            logger.info("getShouldSendNotification() is ---> " + notificationDto.getShouldSendNotification());
        }
    }
}

/*
Tk. $ has been added in your NoboPay wallet from bank.
 */