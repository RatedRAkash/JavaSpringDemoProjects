package com.psl.wso2.np.service.sender_sms;

import com.psl.wso2.np.dto.formatted_dto.producer_obj.SmsRequestQueueFormattedDto;
import com.psl.wso2.np.publisher.ProducerSenderSms;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SenderSmsServiceImpl implements SenderSmsService{

    private static final Logger logger = LogManager.getLogger(SenderSmsServiceImpl.class);

    private ProducerSenderSms producerSenderSms;

    @Autowired
    public SenderSmsServiceImpl(ProducerSenderSms producerSenderSms) {
        this.producerSenderSms = producerSenderSms;
    }

    @Override
    public void sendMessageToProducerSenderSms(SmsRequestQueueFormattedDto smsRequestQueueFormattedDto) {
        logger.info("sending via ProducerSenderSms");
        producerSenderSms.publishMessageToSmsRequestQueue(smsRequestQueueFormattedDto);
    }
}
