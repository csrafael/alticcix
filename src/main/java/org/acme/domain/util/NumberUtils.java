package org.acme.domain.util;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigInteger;

@ApplicationScoped
public class NumberUtils {

    public static boolean isZero(Long number) { return number == 0;}

    public static boolean isLowerThanZero(Long number) { return number < 0;}

    public static boolean isLowerThanTwo(Long number){
        return number <= 2;
    }

    public static boolean isNull(BigInteger value) {
        return value == null;
    }

    public static boolean isNotNull(BigInteger value) {
        return !isNull(value);
    }
}
