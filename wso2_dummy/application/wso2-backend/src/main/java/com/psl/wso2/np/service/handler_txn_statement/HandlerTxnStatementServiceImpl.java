package com.psl.wso2.np.service.handler_txn_statement;

import com.psl.wso2.np.dto.NotificationDto;
import com.psl.wso2.np.handler.HandlersOfTxnTopic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class HandlerTxnStatementServiceImpl implements HandlerTxnStatementService {
    private static final Logger logger = LogManager.getLogger(HandlerTxnStatementServiceImpl.class);

    @Override
    public void processMessage(NotificationDto notificationDto) {
        Boolean shouldSendNotification = notificationDto.getSendNotification();
        Boolean checkOfferOnly = notificationDto.getCheckOfferOnly();

        //if FALSE
        if(!shouldSendNotification){
            logger.info("shouldSendNotification is: " + shouldSendNotification);
            return;
        }

        //if TRUE
        if(checkOfferOnly){
            logger.info("checkOfferOnly is: " + checkOfferOnly);
            return;
        }

        switch (notificationDto.getEventOrigin().getTxnType()) {
            case CASH_IN_FROM_BANK:

                break;


            case CASH_IN_FROM_EXTERNAL:
                break;

            case CASH_OUT_TO_EXTERNAL:
                break;

            case CASH_IN_FROM_CARD:
            case CREDIT_COLLECTION:
//            case CASH_IN_FROM_EXTERNAL:TODO: 2 bar ase
                break;

            case CASH_OUT_TO_BANK:
                break;

            case BILL_PAYMENT:
                break;

            case MOBILE_RECHARGE:
                break;

            case SEND_MONEY:
                break;

            case PAYMENT:
                break;

            case CASHBACK:
                break;

            case REVERSE_TRANSACTION:
                break;

            default:
                break;
        }

        switch (notificationDto.getEventOrigin().getTxnType()) {
            case CASH_IN_FROM_BANK:
            case REVERSE_TRANSACTION:
            case CASH_OUT_TO_BANK:
            case MOBILE_RECHARGE:
            case BILL_PAYMENT:
                //PUT request ---> /api/txn/log
                break;



            default:
                //POST request ---> /api/txn/log
                break;
        }
    }
}
