package com.psl.wso2_dummy.wso2.np.service.handler_txn_notification;

import com.psl.wso2_dummy.wso2.np.constant.EnumConstant.*;
import com.psl.wso2_dummy.wso2.np.dto.EventOriginDto;
import com.psl.wso2_dummy.wso2.np.dto.NotificationDto;
import com.psl.wso2_dummy.wso2.np.dto.formatted_dto.PushTemplateFormattedDto;
import com.psl.wso2_dummy.wso2.np.entity.PushTemplate;
import com.psl.wso2_dummy.wso2.np.repository.PushTemplateRepository;
import com.psl.wso2_dummy.wso2.np.service.publisher_notification.PublisherNotificationService;
import com.psl.wso2_dummy.wso2.np.util.WSO2_Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class HandlerTxnNotificationServiceImpl implements HandlerTxnNotificationService {
    private static final Logger logger = LogManager.getLogger(HandlerTxnNotificationServiceImpl.class);

    private PushTemplateRepository pushTemplateRepository;
    private PublisherNotificationService publisherNotificationService;

    @Autowired
    public HandlerTxnNotificationServiceImpl(PushTemplateRepository pushTemplateRepository, PublisherNotificationService publisherNotificationService) {
        this.pushTemplateRepository = pushTemplateRepository;
        this.publisherNotificationService = publisherNotificationService;
    }

    @Override
    public void processMessageForPublisherNotification(NotificationDto notificationDto) {
        logger.info("processing message to sent to PublisherNotification");

        EventOriginDto rootEvent = notificationDto.getEventOrigin();
        EventType eventType = notificationDto.getEventType();
        String fromAccount = notificationDto.getEventOrigin().getFromAccount();
        String toAccount = notificationDto.getEventOrigin().getToAccount();
        BigDecimal txnAmount = notificationDto.getEventOrigin().getAmount();
        TransactionType txnType = notificationDto.getEventOrigin().getTxnType();
        String status = notificationDto.getEventOrigin().getStatus();
        String MESSAGE = notificationDto.getEventOrigin().getMessage();
        Boolean shouldSendNotification = notificationDto.getSendNotification();
        Boolean checkOfferOnly = notificationDto.getCheckOfferOnly();

        if (checkOfferOnly) {
            logger.info("`checkOfferOnly` is " + checkOfferOnly + " , so dropping message");
            return;
        }

        if (shouldSendNotification != null) {
            if (!shouldSendNotification) {
                logger.info("`shouldSendNotification` is " + shouldSendNotification + " , so dropping message");
            }

            else {
                String mobileNo = null;
                String RECHARGE_MOBILE = null;
                String TITLE = null;
                String PUSH_BODY = null;


                switch (txnType) {

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
                        mobileNo = toAccount;
                        break;

                    case CASH_OUT_TO_MFS_WALLET:
                    case CASH_OUT_TO_BANK:
                    case CASH_OUT_TO_MFS_AGENT:
                    case BILL_PAYMENT:
                    case CASH_OUT_INITIATION:
                    case IDTP_PAYMENT:
                    case IDTP_SEND_MONEY:
                    case DECLINE_RTP:
                        mobileNo = fromAccount;
                        break;

                    case MOBILE_RECHARGE:
                        mobileNo = fromAccount;
                        RECHARGE_MOBILE = notificationDto.getEventOrigin().getMobileNo();
                        break;

                    case CASHBACK:
                        mobileNo = notificationDto.getEventOrigin().getToAccount();
                        TITLE = notificationDto.getEventOrigin().getOfferMessage().getOfferMsg().getPushTitle();
                        PUSH_BODY = notificationDto.getEventOrigin().getOfferMessage().getOfferMsg().getPushBody();
                        break;

                    default:
                        logger.info("Unexpected value: " + txnType);
                        return;
                }

                //DB Call
                List<PushTemplate> pushTemplateList = pushTemplateRepository.wso2messageInfoQuery(txnType.toString());

                if (pushTemplateList.size() > 0) {

                    String templateTitle = pushTemplateList.get(0).getTitle();
                    String msgBodyTemplate = pushTemplateList.get(0).getBody();

                    String newPayload = null;

                    switch (txnType) {
                        case MOBILE_RECHARGE:
                            newPayload = WSO2_Utils.processMessageTemplate(msgBodyTemplate, txnAmount, RECHARGE_MOBILE, status);
                            logger.info("MOBILE_RECHARGE New Payload: " + newPayload);
                            break;

                        case CASHBACK:
                            templateTitle = TITLE;
                            newPayload = PUSH_BODY;
                            logger.info("CASHBACK New Payload: " + newPayload);
                            break;

                        default:
                            newPayload = WSO2_Utils.processMessageTemplate(msgBodyTemplate, txnAmount);
                            logger.info("Default New Payload: " + newPayload);
                            break;
                    }

                    if (notificationDto.getEventOrigin().getStatus().equals("FAILED")) {
                        newPayload = txnType + " request failed";
                        logger.info("Txn FAILED New Payload: " + newPayload);
                    }

                    logger.info("sending via PublisherNotification");
                    publisherNotificationService.sendMessageToNotificationTopic(
                            new PushTemplateFormattedDto(
                                    eventType,
                                    mobileNo,
                                    templateTitle,
                                    newPayload,
                                    rootEvent
                            )
                    );
                }

                else {
                    logger.info("Push template NOT found!");
                }
            }
        }

        else {
            logger.info("Not Sending Notification, because `shouldSendNotification` is ---> " + shouldSendNotification);
        }
    }
}