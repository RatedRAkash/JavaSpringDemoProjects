package com.psl.wso2_dummy.wso2.np.service.handler_txn_notification;

import java.math.BigDecimal;

public class UtilHandlerTxnNotification {
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
