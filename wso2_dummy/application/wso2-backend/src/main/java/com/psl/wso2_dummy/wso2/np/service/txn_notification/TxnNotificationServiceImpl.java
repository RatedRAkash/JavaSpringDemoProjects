package com.psl.wso2_dummy.wso2.np.service.txn_notification;

import com.psl.wso2_dummy.wso2.np.dto.NotificationDto;
import com.psl.wso2_dummy.wso2.np.dto.PushTemplateFromattedDto;
import com.psl.wso2_dummy.wso2.np.entity.PushTemplate;
import com.psl.wso2_dummy.wso2.np.publisher.PublisherNotification;
import com.psl.wso2_dummy.wso2.np.repository.PushTemplateRepository;
import com.psl.wso2_dummy.wso2.np.util.WSO2_Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TxnNotificationServiceImpl implements TxnNotificationService{
    private static final Logger logger = LogManager.getLogger(TxnNotificationServiceImpl.class);

    private PushTemplateRepository pushTemplateRepository;
    private PublisherNotification publisherNotification;

    public TxnNotificationServiceImpl(PushTemplateRepository pushTemplateRepository, PublisherNotification publisherNotification) {
        this.pushTemplateRepository = pushTemplateRepository;
        this.publisherNotification = publisherNotification;
    }

    @Override
    public void processMessageForPublisherNotification(NotificationDto notificationDto) {
        logger.info("processing message to sent to PublisherNotification");

        if(notificationDto.getSendNotification()) {

            String mobileNo = null;
            String RECHARGE_MOBILE = null;
            String TITLE = null;
            String PUSH_BODY = null;

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
                    mobileNo = notificationDto.getEventOrigin().getToAccount();
                    break;

                case CASH_OUT_TO_MFS_WALLET:
                case CASH_OUT_TO_BANK:
                case CASH_OUT_TO_MFS_AGENT:
                case BILL_PAYMENT:
                case CASH_OUT_INITIATION:
                case IDTP_PAYMENT:
                case IDTP_SEND_MONEY:
                case DECLINE_RTP:
                    mobileNo = notificationDto.getEventOrigin().getFromAccount();
                    break;

                case MOBILE_RECHARGE:
                    mobileNo = notificationDto.getEventOrigin().getFromAccount();
                    RECHARGE_MOBILE = notificationDto.getEventOrigin().getMobileNo();
                    break;

                case CASHBACK:
                    mobileNo = notificationDto.getEventOrigin().getToAccount();
                    TITLE = notificationDto.getEventOrigin().getOfferMessage().getOfferMsg().getPushTitle();
                    PUSH_BODY = notificationDto.getEventOrigin().getOfferMessage().getOfferMsg().getPushBody();
                    break;

                default:
                    logger.info("Unexpected value: " + notificationDto.getEventOrigin().getTxnType());
            }

            List<PushTemplate> pushTemplateList = pushTemplateRepository.wso2messageInfoQuery(notificationDto.getEventOrigin().getTxnType().toString());

            String newPayload;
            String templateTitle;

            switch (notificationDto.getEventOrigin().getTxnType()) {
                case MOBILE_RECHARGE:
                    if (pushTemplateList.size() > 0) {
                        newPayload = WSO2_Utils.processMessageTemplate(pushTemplateList.get(0).getBody(), notificationDto.getEventOrigin().getAmount(), mobileNo, notificationDto.getEventOrigin().getStatus());
                        logger.info("New Payload: " + newPayload);
                    }

                case CASHBACK:
                    newPayload = PUSH_BODY;
                    templateTitle = TITLE;

                default:
                    newPayload = WSO2_Utils.processMessageTemplate(pushTemplateList.get(0).getBody(), notificationDto.getEventOrigin().getAmount());
            }

            if (notificationDto.getEventOrigin().getStatus().equals("FAILED")) {
                newPayload = notificationDto.getEventOrigin().getTxnType().toString() + " request failed";
            }

            publisherNotification.sendMessageToNotificationTopic(
                    new PushTemplateFromattedDto(
                            notificationDto.getEventType(),
                            mobileNo,
                            TITLE,
                            PUSH_BODY,
                            notificationDto.getEventOrigin()
                    )
            );
        }

        else {
            logger.info("getShouldSendNotification() is ---> " + notificationDto.getSendNotification());
        }
    }
}