package com.psl.wso2.np.handler;

import com.psl.wso2.np.dto.formatted_dto.producer_obj.SmsRequestQueueFormattedDto;
import com.psl.wso2.np.processor.queue.SmsRequestQueueProcessor;
import com.psl.wso2.np.service.consumer_sms.ConsumerSmsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;


@EnableBinding(SmsRequestQueueProcessor.class)
public class ConsumerOfSmsRequestQueue {
    private static final Logger logger = LogManager.getLogger(ConsumerOfSmsRequestQueue.class);

    private final ConsumerSmsService consumerSmsService;

    @Autowired
    public ConsumerOfSmsRequestQueue(ConsumerSmsService consumerSmsService) {
        this.consumerSmsService = consumerSmsService;
    }

    @StreamListener(target = SmsRequestQueueProcessor.SMS_REQUEST_QUEUE_INPUT)
    public void consumerSms(SmsRequestQueueFormattedDto smsRequestQueueFormattedDto) {
        logger.info("consumerSms consumed ---> " + smsRequestQueueFormattedDto.toString());
        consumerSmsService.processConsumedSms(smsRequestQueueFormattedDto);
    }

}