package com.psl.wso2.np.publisher;

import com.psl.wso2.np.dto.formatted_dto.producer_obj.SmsRequestQueueFormattedDto;
import com.psl.wso2.np.processor.queue.SmsRequestQueueProcessor;
import com.psl.wso2.np.util.WSO2_Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;


@EnableBinding(SmsRequestQueueProcessor.class)
public class ProducerSenderSms {
    private static final Logger logger = LogManager.getLogger(ProducerSenderSms.class);

    private SmsRequestQueueProcessor smsRequestQueueProcessor;

    @Autowired
    public ProducerSenderSms(SmsRequestQueueProcessor smsRequestQueueProcessor) {
        this.smsRequestQueueProcessor = smsRequestQueueProcessor;
    }

    public void publishMessageToSmsRequestQueue(SmsRequestQueueFormattedDto smsRequestQueueFormattedDto) {
        logger.info("SenderSms publishing ---> " + smsRequestQueueFormattedDto.toString());
        //TODO: create Object with all these Tree(EVENT, FROM_ACCOUNT, FROM_BODY)
        smsRequestQueueProcessor.sms_request_queue_output().send((WSO2_Utils.message(smsRequestQueueFormattedDto)));
        logger.info("Sent Message to SmsRequestQueue");
    }

}