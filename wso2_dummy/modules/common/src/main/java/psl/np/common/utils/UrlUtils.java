package psl.np.common.utils;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.List;

public class UrlUtils {

    private static final Joiner URL_JOINER = Joiner.on('/');

    public static String concatUrl(String base, String path) {
        base = Strings.trimEnd(base, '/');
        path = Strings.trimStart(path, '/');
        return base + "/" + path;
    }

    public static String concatUrl(String... parts) {
        List<String> partList = new ArrayList<>(parts.length);
        for(String part : parts) {
            partList.add(Strings.trimBoth(part, '/'));
        }
        return URL_JOINER.join(partList);
    }
}
