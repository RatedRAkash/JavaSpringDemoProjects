package com.psl.wso2.np.service.handler_txn_sms;

import java.math.BigDecimal;

public class UtilHandlerTxnSms {
    public static String formatSmsBody_BILL_PAYMENT_to_account(String FROM_BODY, BigDecimal amount, String TO_ACCOUNT, String TXN_ID, String REFERENCE, String OUTPUT_DATE) {

        String formattedAmount = String.format("%.2f", amount);

        return FROM_BODY.replace("<amount>", formattedAmount)
                .replace("<to_account>", TO_ACCOUNT)
                .replace("<txnId>", TXN_ID)
                .replace("<reference>", REFERENCE)
                .replace("<time>", OUTPUT_DATE);
    }

    public static String formatSmsBody_BILL_PAYMENT_from_account(String TO_BODY, BigDecimal amount, String FROM_ACCOUNT, String TXN_ID, String REFERENCE, String OUTPUT_DATE) {

        String formattedAmount = String.format("%.2f", amount);

        return TO_BODY.replace("<amount>", formattedAmount)
                .replace("<from_account>", FROM_ACCOUNT)
                .replace("<txnId>", TXN_ID)
                .replace("<reference>", REFERENCE)
                .replace("<time>", OUTPUT_DATE);
    }

    public static String formatSmsBody_CASH_IN_FROM_BANK(String FROM_BODY, BigDecimal amount, String BANK_ACCOUNT, String BANK, String TXN_ID, String OUTPUT_DATE) {

        String formattedAmount = String.format("%.2f", amount);

        return FROM_BODY
                .replace("<amount>", formattedAmount)
                .replace("<bank>", BANK)
                .replace("***", BANK_ACCOUNT.substring(0, 3) + "***")
                .replace("<account>", BANK_ACCOUNT.substring(BANK_ACCOUNT.length() - 3))
                .replace("<txnId>", TXN_ID)
                .replace("<time>", OUTPUT_DATE);
    }

    public static String formatSmsBody_CASH_IN_FROM_CARD(String FROM_BODY, BigDecimal amount, String CARD_TYPE, String ACCOUNT, String TXN_ID, String OUTPUT_DATE) {

        String formattedAmount = String.format("%.2f", amount);

        return FROM_BODY
                .replace("<amount>", formattedAmount)
                .replace("<card>", CARD_TYPE)
                .replace("<account>", ACCOUNT)
                .replace("<txnId>", TXN_ID)
                .replace("<time>", OUTPUT_DATE);
    }

    public static String formatSmsBody_CASH_OUT_TO_BANK(String FROM_BODY, BigDecimal amount, String BANK_ACCOUNT, String BANK, String TXN_ID, String OUTPUT_DATE) {

        String formattedAmount = String.format("%.2f", amount);

        return FROM_BODY
                .replace("<amount>", formattedAmount)
                .replace("<bank>", BANK)
                .replace("***", BANK_ACCOUNT.substring(0, 3) + "***")
                .replace("<account>", BANK_ACCOUNT.substring(BANK_ACCOUNT.length() - 3))
                .replace("<txnId>", TXN_ID)
                .replace("<time>", OUTPUT_DATE);
    }

    public static String formatSmsBody_MOBILE_RECHARGE(String FROM_BODY, BigDecimal amount, String OPERATOR, String MOBILE, String TXN_ID, String OUTPUT_DATE) {

        String formattedAmount = String.format("%.2f", amount);

        return FROM_BODY
                .replace("<amount>", formattedAmount)
                .replace("<operator>", OPERATOR)
                .replace("<mobile>", MOBILE)
                .replace("<txnId>", TXN_ID)
                .replace("<time>", OUTPUT_DATE);
    }

    public static String formatSmsBody_PAYMENT_to_account(String FROM_BODY, BigDecimal amount, String TO_ACCOUNT, String TXN_ID, String OUTPUT_DATE) {

        String formattedAmount = String.format("%.2f", amount);

        return FROM_BODY
                .replace("<amount>", formattedAmount)
                .replace("<to_account>", TO_ACCOUNT)
                .replace("<txnId>", TXN_ID)
                .replace("<time>", OUTPUT_DATE);
    }

    public static String formatSmsBody_PAYMENT_from_account(String TO_BODY, BigDecimal amount, String FROM_ACCOUNT, String TXN_ID, String OUTPUT_DATE) {

        String formattedAmount = String.format("%.2f", amount);

        return TO_BODY
                .replace("<amount>", formattedAmount)
                .replace("<from_account>", FROM_ACCOUNT)
                .replace("<txnId>", TXN_ID)
                .replace("<time>", OUTPUT_DATE);
    }

    public static String formatSmsBody_SEND_MONEY_to_account(String FROM_BODY, BigDecimal amount, String TO_ACCOUNT, String TXN_ID, String OUTPUT_DATE) {

        String formattedAmount = String.format("%.2f", amount);

        return FROM_BODY
                .replace("<amount>", formattedAmount)
                .replace("<to_account>", TO_ACCOUNT)
                .replace("<txnId>", TXN_ID)
                .replace("<time>", OUTPUT_DATE);
    }

    public static String formatSmsBody_SEND_MONEY_from_account(String TO_BODY, BigDecimal amount, String FROM_ACCOUNT, String TXN_ID, String OUTPUT_DATE) {

        String formattedAmount = String.format("%.2f", amount);

        return TO_BODY
                .replace("<amount>", formattedAmount)
                .replace("<from_account>", FROM_ACCOUNT)
                .replace("<txnId>", TXN_ID)
                .replace("<time>", OUTPUT_DATE);
    }

    public static String formatSmsBody_IDTP_SENDMONEY_PAYMENT_RTP_SENDMONEY_RTP_PAYMENT(String FROM_BODY, BigDecimal amount, String TXN_ID, String OUTPUT_DATE) {

        String formattedAmount = String.format("%.2f", amount);

        return FROM_BODY
                .replace("<amount>", formattedAmount)
                .replace("<txnId>", TXN_ID)
                .replace("<time>", OUTPUT_DATE);
    }

    public static String formatSmsBody_IDTP_FUND_TRANSFER(String TO_BODY, BigDecimal amount, String TXN_ID, String OUTPUT_DATE) {

        String formattedAmount = String.format("%.2f", amount);

        return TO_BODY
                .replace("<amount>", formattedAmount)
                .replace("<txnId>", TXN_ID)
                .replace("<time>", OUTPUT_DATE);
    }

}
