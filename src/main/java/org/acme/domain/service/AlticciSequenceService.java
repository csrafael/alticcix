package org.acme.domain.service;

import io.quarkus.redis.client.reactive.ReactiveRedisClient;
import org.acme.domain.model.Cache;
import org.acme.domain.util.GlobalConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.constraints.Min;

import static org.acme.domain.util.NumberUtils.*;

@ApplicationScoped
@Service
public class AlticciSequenceService {

    @Autowired
    private Cache cache;

    /**
     * @param Long alticci index number
     * @return Long alticci sequence value
     */
    public Long sequence(Long number) {
        if (isZero(number)) {
            return GlobalConstant.ZERO;
        }
        if (isLowerThanTwo(number)) {
            return GlobalConstant.ONE;
        }

        Long result = cache.get(number.toString());

        if (isNotNull(result) && result > 0) {
            return result;
        }

        final Long firstTermKey = number - 3;
        final Long secondTermKey = number - 2;

        final Long firstTermValue = sequence(firstTermKey);
        final Long secondTermValue = sequence(secondTermKey);

        result = (firstTermValue + secondTermValue);

        cache.set(number.toString(),result);

        return result;
    }
}
