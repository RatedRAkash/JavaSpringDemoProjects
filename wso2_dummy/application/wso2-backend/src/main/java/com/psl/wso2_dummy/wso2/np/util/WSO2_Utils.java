package com.psl.wso2_dummy.wso2.np.util;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import java.math.BigDecimal;

public class WSO2_Utils {
    public static final <T> Message<T> message(T val) {
        return MessageBuilder.withPayload(val)
                .build();
    }

    /*
    Message Body Format
    Tk. $ has been received in your NoboPay wallet. with Mobile No: #, status is: %
     */
    public static String processMessageTemplate(String template, BigDecimal amount, String mobile, String status) {

        String formattedAmount = String.format("%.2f", amount);

        return template.replace("$", formattedAmount)
                .replace("#", mobile)
                .replace("%", status.toLowerCase());
    }

    public static String processMessageTemplate(String template, BigDecimal amount) {

        String formattedAmount = String.format("%.2f", amount);

        return template.replace("$", formattedAmount);
    }
}
