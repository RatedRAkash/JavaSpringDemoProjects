package com.psl.wso2.np.processor.queue;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface SmsRequestQueueProcessor {
    String SMS_REQUEST_QUEUE_INPUT = "SMS_REQUEST_QUEUE_INPUT";
    String SMS_REQUEST_QUEUE_OUTPUT = "SMS_REQUEST_QUEUE_OUTPUT";

    @Input(SMS_REQUEST_QUEUE_INPUT)
    SubscribableChannel sms_request_queue_input();

    @Output(SMS_REQUEST_QUEUE_OUTPUT)
    MessageChannel sms_request_queue_output();
}