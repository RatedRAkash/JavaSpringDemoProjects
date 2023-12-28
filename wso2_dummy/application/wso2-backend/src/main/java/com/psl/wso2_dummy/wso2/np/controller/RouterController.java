package com.psl.wso2_dummy.wso2.np.controller;

import psl.np.dataModel.constant.EnumConstant;
import psl.np.dataModel.dto.NotificationDto;
import com.psl.wso2_dummy.wso2.np.service.txn_service.TxnService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RouterController {

    private static final Logger logger = LogManager.getLogger(RouterController.class);
    private TxnService txnService;


    @Autowired
    public RouterController(TxnService txnService) {
        this.txnService = txnService;
    }

    @PostMapping("/router")
    public ResponseEntity postNotification(@RequestBody NotificationDto notificationDto) {
        if (notificationDto.getEventType() == EnumConstant.EventType.TRANSACTION) {
            txnService.sendMessageToTxnTopic(notificationDto);
        }
        return ResponseEntity.ok("Message Published: " + notificationDto.toString());
    }


//    @PostMapping("/publisher-txn")
//    public ResponseEntity publishMultipleMessage(@RequestBody TxnType txnType){
//
//        publisherTxn.sendMessage(txnType);
//        return ResponseEntity.ok("Message Published: " + txnType.toString());
//    }
}
