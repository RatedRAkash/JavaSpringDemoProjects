package psl.np.dataModel.constant;

public class EnumConstant {
    public enum EventType {
        TRANSACTION, NON_TRANSACTION
    }

    public enum TransactionType {
        CASH_IN,
        PAYMENT,
        SEND_MONEY,
        MOBILE_RECHARGE,
        MERCHANT_PAYMENT,
        SINGLE_QR,
        MULTI_QR
    }
}
