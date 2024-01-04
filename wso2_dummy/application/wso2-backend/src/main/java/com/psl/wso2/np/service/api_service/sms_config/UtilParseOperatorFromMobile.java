package com.psl.wso2.np.service.api_service.sms_config;

import com.psl.wso2.np.constant.EnumConstant.*;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class UtilParseOperatorFromMobile {

    public static MobileOperator getParsedOperatorFromMobile(String Mobile) {
        String prefix = Mobile;
        prefix = prefix.substring(0, 3);

        Pattern patternCase1 = Pattern.compile("^(013|017)$");
        Pattern patternCase2 = Pattern.compile("^(014|019)$");

        Matcher matcherCase1 = patternCase1.matcher(prefix);
        Matcher matcherCase2 = patternCase2.matcher(prefix);

        if (matcherCase1.matches()) {
            return MobileOperator.GP;
        } else if (matcherCase2.matches()) {
            return MobileOperator.BL;
        } else if ("015".equals(prefix)) {
            return MobileOperator.TT;
        } else if ("016".equals(prefix)) {
            return MobileOperator.AIRTEL;
        } else if ("018".equals(prefix)) {
            return MobileOperator.ROBI;
        } else {
            return MobileOperator.CITYCELL;
        }
    }
}
