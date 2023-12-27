package com.psl.wso2_dummy.wso2.controller;

import com.psl.wso2_dummy.wso2.np.model.TxnType;
import com.psl.wso2_dummy.wso2.np.publisher.PublisherTxn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WOS2MessageController {

    private PublisherTxn publisherTxn;


    @Autowired
    public WOS2MessageController(PublisherTxn publisherTxn) {
        this.publisherTxn = publisherTxn;
    }


    @PostMapping("/publisher-txn")
    public ResponseEntity publishMultipleMessage(@RequestBody TxnType txnType){

        publisherTxn.sendMessage(txnType);
        return ResponseEntity.ok("Message Published: " + txnType.toString());
    }
}
