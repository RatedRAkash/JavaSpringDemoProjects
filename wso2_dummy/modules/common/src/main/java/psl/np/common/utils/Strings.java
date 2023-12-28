package psl.np.common.utils;

import psl.np.dataModel.constant.Validators;

public class Strings {

    public static boolean isNullOrEmpty(String value) {
        return com.google.common.base.Strings.isNullOrEmpty(value);
    }

    public static boolean isNullOrWhiteSpace(String value) {
        boolean result = isNullOrEmpty(value);
        if (!result) {
            result = isNullOrEmpty(value.trim());
        }
        return result;
    }
    public static boolean isNotNullButEmpty(String value){
        return (value!=null && isNullOrEmpty(value));
    }

    public static boolean notBlank(String value) {
        return !isNullOrEmpty(value);
    }

    public static boolean containsIgnoreCase(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return false;
        }
        int len = searchStr.length();
        int max = str.length() - len;

        for (int i = 0; i <= max; ++i) {
            if (str.regionMatches(true, i, searchStr, 0, len)) {
                return true;
            }
        }
        return false;
    }

    public static String assignIfNullOrEmpty(String value, String defaultValue) {
        if (isNullOrEmpty(value) || value.trim().equalsIgnoreCase("null")) {
            value = defaultValue;
        }
        return value;
    }

    public static String trimEnd(String value, char ch) {
        int len = value.length() - 1;
        while (len >= 0 && value.charAt(len) == ch) {
            len--;
        }
        return value.substring(0, len + 1);
    }

    public static String trimStart(String value, char ch) {
        int len = value.length();
        int i = 0;
        while (i < len && value.charAt(i) == ch) {
            i++;
        }
        return value.substring(i, len);
    }

    public static String trimBoth(String value, char ch) {
        value = trimStart(value, ch);
        value = trimEnd(value, ch);
        return value;
    }

    public static String repeat(String value, int count) {
        return com.google.common.base.Strings.repeat(value, count);
    }
    public static boolean isWallet(String walletNo) {
        return !Strings.isNullOrEmpty(walletNo) &&walletNo.matches(Validators.WALLET_PATTERN);
    }
}
