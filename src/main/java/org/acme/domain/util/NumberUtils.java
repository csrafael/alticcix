package org.acme.domain.util;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class NumberUtils {
    /**
     * @param Long number
     * @return true when the param equals zero
     */
    public static boolean isZero(Long number) {
        return number == 0;
    }

    /**
     * @param Long number
     * @return true when the param is lower than two
     */
    public static boolean isLowerThanTwo(Long number){
        return number <= 2;
    }

    public static boolean isNull(Long value) {
        return value == null;
    }

    public static boolean isNotNull(Long value) {
        return !isNull(value);
    }
}
