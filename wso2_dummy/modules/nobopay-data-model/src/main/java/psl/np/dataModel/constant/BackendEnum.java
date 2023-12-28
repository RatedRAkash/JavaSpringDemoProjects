package psl.np.dataModel.constant;

public class BackendEnum {

    public static final String AUTH_HEADER = "Authorization";
    public static final String ACCESS_TOKEN = "x-auth-token";

    public enum AddressType {
        PRESENT,
        PERMANENT,
        BUSINESS
    }

    public enum VerStatus {
        EFT_PENDING,
        PENDING,
        REJECTED,
        VERIFIED
    }

    public enum BankAccountStatus {
        PENDING,
        VERIFIED,
        FAILED
    }

    public enum IdtpAccountStatus {
        PIN_NOT_SET,
        VERIFIED,
        NOT_FOUND,
        NOT_ATTACHED
    }

    public enum DocStatus {
        PENDING,
        REJECTED,
        IMAGE_VERIFICATION_PENDING,
        VERIFIED
    }

    public enum IdentityStatus {
        NOT_SET,
        PENDING,
        VERIFYING,
        VERIFIED
    }
    public enum AccountOperationType{
        UPDATE_WALLET_TYPE,
        UPDATE_WALLET_STATUS,
        UNBLOCK_OTP,
        UNBLOCK_PIN,
        UNBLOCK_BANK_ACCOUNT,
        ATTACH_BANK_ACCOUNT,
        ATTACH_OUTLET_COUNTER
    }

    public enum DocSubType {
        NID_FRONT,
        NID_BACK,
        PASSPORT,
        DRIVING_FRONT,
        DRIVING_BACK,
        TIN,
        TRADE_LICENSE_VALIDITY,
        TRADE_LICENSE_PROFILE,
        SHOP_IMAGE_1,
        SHOP_IMAGE_2,
        MERCHANT_QR_CODE;

        public DocumentType getBaseType() {
            switch (this) {
                case NID_FRONT:
                case NID_BACK:
                    return DocumentType.NID;
                case DRIVING_FRONT:
                case DRIVING_BACK:
                    return DocumentType.DRIVING_LICENSE;
                case PASSPORT:
                    return DocumentType.PASSPORT;
                case TIN:
                    return DocumentType.TIN;
                case TRADE_LICENSE_PROFILE:
                case TRADE_LICENSE_VALIDITY:
                    return DocumentType.TRADE_LICENSE;
                case SHOP_IMAGE_1:
                case SHOP_IMAGE_2:
                    return DocumentType.SHOP_IMAGE;
                case MERCHANT_QR_CODE:
                    return DocumentType.QR_CODE;
            }
            return null;
        }

        public boolean isFront() {
            switch (this) {
                case NID_FRONT:
                case DRIVING_FRONT:
                case PASSPORT:
                case TIN:
                case TRADE_LICENSE_PROFILE:
                    return true;
            }
            return false;
        }

        public boolean isBack() {
            return !this.isFront();
        }
    }

    public enum AccountStatus {
        PENDING,
        BANK_VERIFIED,
        ID_VERIFIED,
        ACTIVE,
        SUSPENDED
    }

    public enum MicroTxnStatus {
        PENDING,
        VERIFIED,
        FAILED
    }
    public enum CardNetwork{
        VISA,
        MASTERCARD,
        AMERICAN_EXPRESS
    }
    public enum CardType{
        DEBIT,
        CREDIT,
        PREPAID
    }

//    public enum BizType {
//        SHOP,
//        SUPER_SHOP,
//        ONLINE_SHOP,
//        UTILITY_MERCHANT,
//        TK_MERCHANT,
//        GROCERY,
//        CLOTH_STORE,
//        MFS_MOBILE_RECHARGE,
//        BAKERY_AND_CONFECTIONERY,
//        HOUSEHOLD_AND_FURNITURE,
//        STATIONERY,
//        SHOE_STORE,
//        DISTRIBUTOR_OR_WHOLESALE,
//        HARDWARE,
//        PHARMACY,
//        COSMETICS,
//        RESTAURANT_SWEETS_STORE,
//        ELECTRONICS,
//        AGRICULTURE,
//        ROD_CEMENT,
//        MOTOR_REPAIR,
//        TAILORS,
//        OTHERS,
//        OPTICS_STORE,
//        LIFESTYLE,
//        ELECTRICAL_SHOP ,
//        PET_SHOP ,
//        CROCKERIES,
//        SPORTS_ITEMS,
//        GIFT_SHOP,
//        MENS_SALON,
//        WATCH,
//        HANDICRAFT,
//        COSMETIC_SHOP,
//        BEAUTY_PARLOUR,
//        JEWELLERY,
//        RESTAURANT,
//        SWEET_SHOP,
//        MOBILE_AND_ACCESSORIES,
//        COMPUTER_AND_ACCESSORIES,
//        ELECTRONIC_SHOP
//    }
    public enum SQrStatus{
        APPROVED,
        REJECTED
    }

    public enum Priority {
        LOW,
        MEDIUM,
        HIGH
    }

    public enum BPTouchGroup {
        TASK,
        SERVICE_REQUEST
    }

    public enum BPTaskStatus {
        CREATED,
        READ,
        TODO,
        ASSIGNED,
        IN_PROGRESS,
        DONE,
        CANCELED,
        VERIFIED,
        VERIFICATION_FAILED
    }

    public enum BPServiceStatus {
        CREATED,
        IN_PROGRESS,
        COMPLETED
    }

    public enum BankTxnType {
        CASH_IN,
        CASH_OUT,
        MICRO_TXN,
        CARD_TXN,
        CREDIT_COLLECTION,
        LOAN_REPAYMENT
    }

    public enum IdtpTxnType {
        SEND_MONEY,
        PAYMENT,
        FUND_TRANSFER,
        REQUEST_RTP,
        PROCESS_RTP
    }

    public enum BankTxnStatus {
        PENDING,
        REQUESTED,
        SUCCESS,
        FAILED,
        TIMEOUT,
        CALL_FAILED
    }

    public enum IdtpTxnStatus {
        PENDING,
        REQUESTED,
        SUCCESS,
        FAILED,
        TIMEOUT,
        CALL_FAILED,
        REJECTED,
        REVERSED
    }
    public static enum WalletAccountStatus {
        PENDING("PE"),
        BANK_VERIFIED("BV"),
        ID_VERIFIED("IV"),
        ACTIVE("AC"),
        SUSPENDED("SU");

        private final String value;

        private WalletAccountStatus(final String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    public enum UserType {
        CUSTOMER,
        SHOP,
        ONLINE_SHOP,
        UTILITY_MERCHANT
    }

    public enum UserRole {
        ROLE_COUNTER_EXEC,
        ROLE_OUTLET_MANAGER
    }

    public enum ACCOUNT_TYPE {
        BANK, CARD, MFS
    }

    public enum DocumentType {
        NID(true),
        DRIVING_LICENSE(false),
        PASSPORT(false),
        TRADE_LICENSE(true),
        TIN(false),
        SHOP_IMAGE(true),
        QR_CODE(true);

        private boolean active;

        DocumentType(boolean active) {
            this.active = active;
        }

        public boolean isActive() {
            return active;
        }

        public DocSubType getFront() {
            switch (this) {
                case NID:
                    return DocSubType.NID_FRONT;
                case DRIVING_LICENSE:
                    return DocSubType.DRIVING_FRONT;
                case PASSPORT:
                    return DocSubType.PASSPORT;
                case TRADE_LICENSE:
                    return DocSubType.TRADE_LICENSE_PROFILE;
                case TIN:
                    return DocSubType.TIN;
            }
            return null;
        }

        public DocSubType getBack() {
            switch (this) {
                case NID:
                    return DocSubType.NID_BACK;
                case DRIVING_LICENSE:
                    return DocSubType.DRIVING_BACK;
                case PASSPORT:
                    return DocSubType.PASSPORT;
                case TRADE_LICENSE:
                    return DocSubType.TRADE_LICENSE_VALIDITY;
                case TIN:
                    return DocSubType.TIN;
            }
            return null;
        }
    }

    public enum EventOriginType {
        BANK_ACCOUNT, IDENTITY_DOCUMENT
    }

    public enum EventOriginStatus {
        VERIFIED, REJECTED
    }

    public enum BILLER_STEP {
        PAYMENT, ENQUIRY, GENERAL
    }

    public enum TOPUP_VENDOR_IDENTIFIER {
        SSD_TECH, PRAN_RFL, PORTONICS
    }

    public enum TELCO_OPERATOR {
        GP, BL, TT, ROBI, AIRTEL
    }

    public enum TOPUP_FAILURE_EVENT {
        CHANGE_VENDOR, INC_COUNTER
    }

    public enum MOBILE_TOPUP_TYPE {
        PREPAID, POSTPAID
    }

    public enum NomineeStatus {
        PENDING, VERIFIED, INVALID
    }

    public enum NidType {
        SMART_CARD,
        LEGACY_NID
    }

    public enum CredentialType {
        PIN,
        FINGER_PRINT,
        OTP
    }

    public enum SimVerificationStatus {
        MATCHED,
        NOT_MATCHED,
        NOT_CHECKED
    }


}
