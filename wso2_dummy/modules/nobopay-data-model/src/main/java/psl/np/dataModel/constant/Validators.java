package psl.np.dataModel.constant;

public class Validators {

    public static final String MOBILE_PATTERN = "^(?:\\+?88|0088)?01[13-9]\\d{8}$";
    public static final String INVALID_MOBILE = "Invalid mobile number";
    public static final String WALLET_PATTERN = "^01[13-9]\\d{8}$";
    public static final String INVALID_WALLET = "Invalid wallet number";
    public static final String INVALID_NUMBER = "Invalid secondary phone number";
    public static final String SC_WALLET = "^01[3-9][0-9]{9}$";
    public static final String EMPTY_OR_WALLET = "^(\\s*|(01[13-9]\\d{8})){1}$";
    public static final String PIN_PATTERN = "^\\d{4}$";
    public static final String INVALID_PIN = "PIN should be 4 digit long and numeric only";
    public static final String NID_PATTERN ="^(\\d{10}|\\d{13}|\\d{17})$";
    public static final String INVALID_NID = "NID must be 10 or 13 or 17 digits only";
}
