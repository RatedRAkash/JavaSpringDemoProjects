package com.tutorial.akash_spring_cloud_stream.wso2_dummy.controller;

import com.tutorial.akash_spring_cloud_stream.wso2_dummy.np.model.TxnType;
import com.tutorial.akash_spring_cloud_stream.wso2_dummy.np.publisher.PublisherTxn;
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
