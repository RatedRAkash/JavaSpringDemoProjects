package com.psl.wso2.np.constant;

public class EnumConstant {
    public enum EventType {
        TRANSACTION, NON_TRANSACTION, LOGIN
    }

    public enum TransactionType {
        BILL_PAYMENT,
        CASHBACK,
        CASH_OUT_TO_MFS_WALLET,
        CASH_IN_FROM_MFS_WALLET,
        MOBILE_RECHARGE,
        CASH_OUT_TO_BANK,
        CASH_IN_FROM_BANK,
        CASH_IN_FROM_CARD,
        SEND_MONEY,
        PAYMENT,
        PAYMENT_EXTERNAL,
        IDTP_SEND_MONEY,
        IDTP_PAYMENT,
        IDTP_FUND_TRANSFER,
        REVERSE_TRANSACTION,// Only for txn reverse request
        CREDIT_COLLECTION,
        CASH_IN_FROM_EXTERNAL,
        CASH_OUT_TO_EXTERNAL,
        SYSTEM_TO_WALLET,
        WALLET_TO_SYSTEM,
        CASH_IN_FROM_LOAN_CREDIT,
        LOAN_REPAYMENT,
        DISBURSEMENT,
        NPSB_TRANSFER,
        NPSB_TRANSFER_CREDIT,
        CASH_IN_FROM_MFS_AGENT,
        CASH_IN_INITIATION,
        PROCESS_RTP,
        CASH_OUT_TO_MFS_AGENT,
        CASH_OUT_INITIATION,
        DECLINE_RTP,
        IDTP_RTP_SEND_MONEY,
        IDTP_RTP_PAYMENT
    }

    public enum SmsVendor {
        TALLYKHATA,
        MOBIREACH
    }

    public enum MobileOperator {
        GP("GrameenPhone"),
        BL("BanglaLink"),
        TT("Teletalk"),
        AIRTEL("Airtel"),
        ROBI("Robi"),
        CITYCELL("CITYCELL");

        private String name;

        MobileOperator(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public static MobileOperator getOperator(String name) {
            for (MobileOperator mobileOperator : MobileOperator.values()) {
                if (mobileOperator.getName().equals(name)) {
                    return mobileOperator;
                }
            }
            return null;
        }
    }
}
