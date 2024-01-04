package com.psl.wso2.np.controller;

import com.psl.wso2.np.dto.NotificationDto;
import com.psl.wso2.np.service.handler_txn_notification.HandlerTxnNotificationService;
import com.psl.wso2.np.service.publisher_txn.PublisherTxnService;
import com.psl.wso2.np.service.router.RouterService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WSO2Controller {

    private static final Logger logger = LogManager.getLogger(WSO2Controller.class);

    private RouterService routerService;
    private PublisherTxnService publisherTxnService;
    private HandlerTxnNotificationService handlerTxnNotificationService;


    @Autowired
    public WSO2Controller(RouterService routerService, PublisherTxnService publisherTxnService, HandlerTxnNotificationService handlerTxnNotificationService) {
        this.routerService = routerService;
        this.publisherTxnService = publisherTxnService;
        this.handlerTxnNotificationService = handlerTxnNotificationService;
    }

    @PostMapping("/router")
    public ResponseEntity<?> postNotification(@RequestBody NotificationDto notificationDto) {
        routerService.routeMessage(notificationDto);
        return ResponseEntity.ok("Router Message Published: " + notificationDto.toString());
    }

    @PostMapping("/txn-topic")
    public ResponseEntity<?> postTxnTopic(@RequestBody NotificationDto notificationDto) {
        publisherTxnService.sendMessageToTxnTopic(notificationDto);
        return ResponseEntity.ok("Txn-Topic Message Published: " + notificationDto.toString());
    }

    @PostMapping("/notification-topic")
    public ResponseEntity<?> postNotificationTopic(@RequestBody NotificationDto notificationDto) {
        handlerTxnNotificationService.processMessageForPublisherNotification(notificationDto);
        return ResponseEntity.ok("Notification-Topic Message Published: " + notificationDto.toString());
    }

//    @PostMapping("/publisher-txn")
//    public ResponseEntity publishMultipleMessage(@RequestBody TxnType txnType){
//
//        publisherTxn.sendMessage(txnType);
//        return ResponseEntity.ok("Message Published: " + txnType.toString());
//    }
}
