package psl.np.common.utils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ListUtils {

    public static <T> Collector<T, ?, T> firstOrDefault() {
        return Collectors.collectingAndThen(
                Collectors.toList(),
                list -> {
                    if (list == null || list.size() == 0) {
                        return null;
                    }
                    return list.get(0);
                }
        );
    }

    public static <T> List<T> nullToEmpty(List<T> list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        return list;
    }

    public static boolean isNullOrEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * Check if first argument matches any of following argument. All argument should be subset of
     * enum class
     * @param value value to match
     * @param values values to match with
     * @return true if first argument matches any of later argument, otherwise false
     */
    public static <T extends Enum> boolean valueIn(T value, T... values) {
        if (values == null || values.length == 0) {
            return false;
        }
        for (T val : values) {
            if (value == val) {
                return true;
            }
        }
        return false;
    }
}
