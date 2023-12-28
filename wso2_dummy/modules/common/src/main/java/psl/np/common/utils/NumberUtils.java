package psl.np.common.utils;

import java.math.BigDecimal;

public class NumberUtils {

    public static boolean isPositive(Integer value) {
        return value != null && value > 0;
    }

    public static boolean isPositive(Long value) {
        return value != null && value > 0;
    }

    public static boolean isEqual(BigDecimal a, BigDecimal b) {
        if (a == null) {
            return b == null;
        }
        return a.compareTo(b) == 0;
    }

    public static boolean isNotEqual(BigDecimal a, BigDecimal b) {
        return !isEqual(a, b);
    }

    public static int nullToZero(Integer value) {
        return value == null ? 0 : value;
    }

    public static long divideCeil(long value, long divider) {
        return (value / divider) + (value % divider == 0 ? 0 : 1);
    }
}
