package com.psl.wso2.np.service.router;

import com.psl.wso2.np.dto.NotificationDto;
import com.psl.wso2.np.service.publisher_txn.PublisherTxnService;
import com.psl.wso2.np.constant.EnumConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouterServiceImpl implements RouterService{
    private static final Logger logger = LogManager.getLogger(RouterServiceImpl.class);

    private PublisherTxnService publisherTxnService;

    @Autowired
    public RouterServiceImpl(PublisherTxnService publisherTxnService) {
        this.publisherTxnService = publisherTxnService;
    }


    @Override
    public void routeMessage(NotificationDto notificationDto) {
        if (notificationDto.getEventType() == EnumConstant.EventType.TRANSACTION) {
            publisherTxnService.sendMessageToTxnTopic(notificationDto);
        }else{
            //TODO hala madrid: NON_TRANSACTION
        }
    }
}
