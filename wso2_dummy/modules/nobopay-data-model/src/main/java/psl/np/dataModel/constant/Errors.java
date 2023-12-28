package psl.np.dataModel.constant;

import java.util.HashMap;
import java.util.Map;

public enum Errors {
    // Common errors
    VALIDATION_ERROR(400, 4000, "Request parameters is not valid"),
    INTERNAL_SERVER(500, 5000, "Something went wrong"),
    INVALID_ROLE(400, 4055, "Invalid user role"),
    ROLE_MISMATCH(400, 4005, "Please login with a valid %s account"),
    URL_NOT_FOUND(404, 4044, "Requested resource was not found on the server"),
    INFO_NOT_FOUND(400, 4035, "Information not found"),
    DUPLICATE_REF_NO(400, 4088, "Duplicate reference No provided"),

    // Security and credential related
    UNAUTHORIZED(401, 4011, "Unauthorized"),
    OTP_BLOCKED(400, 4426, "Your OTP has been blocked for %s hours. Please try later for new OTP."),
    INVALID_OTP_WARN(400, 4022, "You entered wrong OTP %s times. Your account will be blocked if you enter wrong OTP 1 more time."),
    INVALID_OTP_EXCEED(400, 4023, "Dear valued TallyPay user, for entering wrong OTP %s times, your OTP has been blocked for %s hours. Please try later for new OTP."),
    INVALID_OTP(400, 4400, "Invalid OTP"),
    OTP_ALREADY_USED(400, 4425, "OTP already used"),
    OTP_ALREADY_SENT(400, 4505, "OTP already sent. Please try again later"),
    MOBILE_NOT_VERIFIED(400, 4500, "Mobile not verified"),
    INVALID_CREDENTIAL(401, 4010, "Invalid credentials"),
    INVALID_SECURITY_ANSWER(400, 4422, "Invalid question answer"),
    MULTIPLE_ATTEMPT_ERROR(400, 4428, "Too many wrong security question answered. Security question has been locked for today"),
    SECURITY_QUESTION_LOCKED(400, 4429, "Security question has been locked for today"),
    DUPLICATE_ANSWER(500, 5051, "Duplicate answer"),
    LOGIN_WRONG_PIN_WARNING(403, 4020, "You entered wrong PIN %s times. Your account will be blocked if you enter wrong PIN 1 more time."),
    LOGIN_WRONG_PIN_EXCEED(403, 4021, "Dear valued TallyPay user, for entering wrong PIN %s times, your account has been blocked for %s hour. Please try to login later."),
    INVALID_REFRESH_TOKEN(401, 4012, "Invalid Refresh Token"),
    OBVIOUS_PIN(400, 4423, "PIN too simple"),
    INVALID_FP(401, 4014, "Invalid fingerprint provided"),
    PIN_ALREADY_USED(400, 4408, "PIN already used"),
    PIN_BLOCKED(403, 4013, "Your PIN has been blocked for %s hour. Please try again later."),
    USER_BLOCKED(403, 4018, "Dear valued TallyPay user, your wallet has been temporary blocked. Please call 09609090908 for assistance."),
    BLOCKED_USER_RESET_PIN_ATTEMPT(403, 4098, "Dear valued TallyPay user, your wallet has been temporary blocked."),
    REGISTRATION_NOT_COMPLETED(403, 4059, "Registration not completed."),
    TRADE_LICENSE_VERIFICATION_NOT_ALLOWED(400, 4059, "Trade license verification not allowed"),

    // Profile and device
    WALLET_ALREADY_EXISTS(400, 4090, "Another account already exists with this mobile number"),
    DEVICE_NOT_REGISTERED(400, 4040, "Device not registered"),
    PROFILE_NOT_FOUND(400, 4004, "User profile not found"),
    PROFILE_NOT_MATCH(400, 4005, "User profile not match"),
    ACCOUNT_ALREADY_EXISTS(400, 4502, "Account already exist"),
    LOAN_INFO_NOT_FOUND(403, 4550, "No loan information found."),
    SUGAR_ATTACHED_ACCOUNT_NOT_FOUND(400, 4998, "Sugar attached account not found"),
    SUGAR_TAG_UPDATE_FAILED_IN_EPURJEE_SYSTEM(400, 4995, "Sugar tag update failed in e-purjee system"),

    //Account related
    ACCOUNT_VERIFICATION_FAILED(400, 4034, "Failed to verify account"),
    ACCOUNT_VERIFICATION_TRIES_EXCEED(400, 4039, "Dear valued TallyPay user, your wallet has been temporary blocked for entering wrong token money amount %s times. Please call 09609090908 for assistance."),
    ACCOUNT_VERIFICATION_TRIES_WARN(400, 4041, "You entered wrong token money amount %s times. Your account will be blocked if you enter wrong token money amount 1 more time."),
    ACCOUNT_VERIFICATION_LOCKED(400, 4042, "Your bank account verification is locked"),
    OTHER_BANK_CASH_IN_NOT_AVAILABLE(400, 4102, "Bank Cash-in Temporarily Unavailable"),
    OTHER_BANK_CASH_OUT_NOT_AVAILABLE(400, 4103, "Bank Cash-out Temporarily Unavailable"),
    BRANCH_NOT_FOUND(400,4104,"Branch Not found for Routing Number and Swift code"),
    ACCOUNT_NOT_ACTIVE(400,4403,"Wallet or Account not active"),
    ACCOUNT_NOT_EKYC_VERIFIED(400,4709,"Wallet or Account is not ekyc verified"),
    WALLET_BANK_STATUS_NOT_VERIFIED(403,4081,"Bank Account is not verified for this wallet"),

    // IDTP related
    IDTP_ACCOUNT_NOT_FOUND(400, 4043, "IDTP account not found"),
    IDTP_ACCOUNT_ALREADY_EXISTS(400, 4047, "IDTP account already exits for userId: %s"),
    IDTP_TXN_REQUEST_NOT_FOUND(400, 4048, "IDTP transaction request not found"),

    // Documents and Files
    DOC_ALREADY_VERIFIED(400, 4029, "Document already verified"),
    DOC_ALREADY_REJECTED(400, 4029, "Document already Rejected"),
    DOC_ALREADY_USED(400, 4019, "Document already used"),
    NID_ALREADY_USED(400, 4799, "NID already used by other user with same user group of %s"),
    DOC_TYPE_NOT_SUPPORTED(400, 4009, "Document type not supported"),
    DOC_NOT_FOUND(400, 4032, "Document not found"),
    NID_INFO_NOT_FOUND(400, 4054, "NID information not found"),
    FILE_READ_ERROR(500, 5098, "Can not read file from request"),
    INVALID_NID_FRONT_IMAGE(400, 4052, "Invalid image for NID front side"),
    INVALID_NID_BACK_IMAGE(400, 4053, "Invalid image for NID back side"),
    PICTURE_TYPE_NIT_SUPPORTED(400, 4057, "Picture type not supported"),
    INVALID_FACE_IMAGE(400, 4058, "Face image does not match"),

    // Biz related user related
    MERCHANT_NOT_FOUND(400, 4700, "Merchant not found"),
    USER_IS_ALREADY_MERCHANT(400, 4704, "User is already a merchant"),
    OUTLET_NOT_FOUND(400, 4701, "Outlet not found"),
    SHOP_INFO_NOT_FOUND(400, 4703, "Shop info not found"),
    USER_IS_NOT_MERCHANT(400,4705,"User is not Merchant"),
    MERCHANT_ID_NOT_FOUND(400,4707,"No merchant Id found for this merchant"),
    NOT_ELIGIBLE_FOR_SQR(400,4708,"%s (%s) is not eligible for SuperQr"),
    DATA_MODIFICATION_NOT_ALLOWED(403,4710,"Data modification is not allowed"),
    BANK_ACCOUNT_ALREADY_EXIST(400,4711,"Bank account already exists"),

    // Corporate User Portal Related
    TXN_TYPES_NOT_ALLOWED(400,4610,"Txn Type is not allowed"),
    NO_TXN_TYPES_SELECTED(400, 4611, "No txnTypes selected"),

    // Offers related
    OFFER_MESSAGE_TEMPLATE_NOT_FOUND(400, 4600, "No message template found for id %s"),
    TXN_OFFER_NOT_FOUND(400, 4601, "No txn offer found with ID: %s"),
    OFFER_USAGE_NOT_FOUND(404, 4602, "No usage found with provided txn id"),

    // BanglaQr related
    INVALID_BANGLA_QR(400, 4800, "Not a valid bangla qr"),

    //Porichoy Errors
    PORICHOY_VERIFICATION_ERROR(400, 40430, "Porichoy Verification Error"),
    PORICHOY_NOT_EXISTS_ERROR(400, 40431, "Porichoy doesn't exist"),
    PORICHOY_UNAVAILABLE(500, 50211, "Porichoy Undefined"),

    DUPLICATE_SECONDARY_PHONE_NUMBER(400, 4977, "Secondary phone number %s already exists"),
    INVALID_SECONDARY_PHONE_NUMBER(400, 490, "Invalid secondary phone number"),
    WALLET_SECONDAY_NUMBER_SAME(400, 40432, "Wallet and secondary number same");


    //custom message from different component
//    CM_FACE_MATCHING_ERROR(401, 45010, "Profile picture doesn't match with EC picture"),
//    OCR_OPERATION_EXCEPTION_1(406, 44010, "Your captured picture is not clear, please take again!"),
//    OCR_OPERATION_EXCEPTION_2(406, 44030, "Your captured picture is not clear, please take again!"),
//    OCR_OPERATION_EXCEPTION_3(406, 44020, "Your captured picture is not clear, please take again!"),
//    OCR_OPERATION_EXCEPTION_4(406, 44000, "Your captured picture is not clear, please take again!"),
//    OCR_OPERATION_EXCEPTION_5(406, 44040, "Date of birth is missing in your NID"),
//    OCR_OPERATION_EXCEPTION_6(406, 44050, "Your captured picture is not clear, please take again!"),
//    OCR_OPERATION_EXCEPTION_7(406, 44060, "Your captured picture is not clear, please take again!");

    Errors(int httpCode, int code, String message) {
        this.httpCode = httpCode;
        this.code = code;
        this.message = message;
    }

    private static final Map<Integer, Errors> customCodeToErrorsMap = new HashMap<>();
    static {
        for (Errors type : Errors.values()){
            customCodeToErrorsMap.put(type.code, type);
        }
    }

    public static Errors fromCode(int i) {
        return customCodeToErrorsMap.get(i);
    }

    private int httpCode;
    private int code;
    private String message;

    public int getHttpCode() {
        return httpCode;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
