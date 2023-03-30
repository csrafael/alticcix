package org.acme.domain.util;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;
@QuarkusTest
class NumberUtilsTest {

    @Test
    void isZero() {
        Assertions.assertEquals(true, NumberUtils.isZero(0L));
    }

    @Test
    void isLowerThanZero() {
        Assertions.assertEquals(true, NumberUtils.isLowerThanZero(-1L));
    }

    @Test
    void isLowerThanTwo() {
        Assertions.assertEquals(true, NumberUtils.isLowerThanTwo(1L));
    }

    @Test
    void isNull() {
        Assertions.assertEquals(true, NumberUtils.isNull(null));
    }

    @Test
    void isNotNull() {
        Assertions.assertEquals(true, NumberUtils.isNotNull(new BigInteger("100")));
    }
}