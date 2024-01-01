package com.psl.wso2_dummy.wso2.np.service.handler_txn_sms;

import java.math.BigDecimal;

public class UtilHandlerTxnSms {
    public static String formatBILLPAYMENTSmsBody(String FROM_BODY, BigDecimal amount, String TO_ACCOUNT, String TXN_ID, String REFERENCE, String OUTPUT_DATE) {

        String formattedAmount = String.format("%.2f", amount);

        return FROM_BODY.replace("&lt;amount&gt;", formattedAmount)
                .replace("&lt;to_account&gt", TO_ACCOUNT)
                .replace("&lt;txnId&gt;", TXN_ID)
                .replace("&lt;reference&gt;", REFERENCE)
                .replace("&lt;time&gt;", OUTPUT_DATE);
    }

}
