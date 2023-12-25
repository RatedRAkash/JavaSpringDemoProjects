package com.psl.wso2_dummy.controller;

import com.psl.wso2_dummy.wso2.np.model.TxnType;
import com.psl.wso2_dummy.wso2.np.publisher.PublisherTxn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyCustomMessageController {

    private PublisherTxn publisherTxn;


    @Autowired
    public MyCustomMessageController(PublisherTxn publisherTxn) {
        this.publisherTxn = publisherTxn;
    }


    @PostMapping("/publisher-txn")
    public ResponseEntity publishMultipleMessage(@RequestBody TxnType txnType){

        publisherTxn.sendMessage(txnType);
        return ResponseEntity.ok("Message Published: " + txnType.toString());
    }
}
