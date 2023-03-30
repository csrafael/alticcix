package org.acme.domain.service;

import org.acme.domain.exception.ValidationException;
import org.acme.domain.model.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigInteger;

import static org.acme.domain.util.NumberUtils.*;

@ApplicationScoped
@Service
public class AlticciSequenceService {

    @Autowired
    private Cache cache;

    public BigInteger sequence(Long number) {
        validate(number);
        return calculateSequence(number);
    }

    /**
     * @param  number - alticci index
     * @return BigInteger alticci sequence value
     */
    private BigInteger calculateSequence(Long number) {
        if (isZero(number)) {
            return BigInteger.ZERO;
        }
        if (isLowerThanTwo(number)) {
            return BigInteger.ONE;
        }

        BigInteger result = cache.get(number.toString());

        if (isNotNull(result) && result.longValue() > 0) {
            return result;
        }

        final Long firstTermKey = number - 3;
        final Long secondTermKey = number - 2;
        final BigInteger firstTermValue = sequence(firstTermKey);
        final BigInteger secondTermValue = sequence(secondTermKey);

        result = firstTermValue.add(secondTermValue);

        cache.set(number.toString(),result);

        return result;
    }

    private void validate(Long number) {
        if (isLowerThanZero(number)) {
            throw new ValidationException("deve ser um valor maior ou igual a zero");
        }
    }
}
