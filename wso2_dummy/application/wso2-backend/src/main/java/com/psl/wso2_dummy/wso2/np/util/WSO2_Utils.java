package com.psl.wso2_dummy.wso2.np.util;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import java.math.BigDecimal;

public class WSO2_Utils {
    public static final <T> Message<T> message(T val) {
        return MessageBuilder.withPayload(val)
                .build();
    }
}
