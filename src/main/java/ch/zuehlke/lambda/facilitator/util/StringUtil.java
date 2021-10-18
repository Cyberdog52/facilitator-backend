package ch.zuehlke.lambda.facilitator.util;

import org.springframework.util.ObjectUtils;

public class StringUtil {

    public static String toStringOrDefault(Object value, String defaultValue) {
        return ObjectUtils.isEmpty(value) ? defaultValue : value.toString();
    }
}
