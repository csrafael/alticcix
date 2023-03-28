package org.acme.domain.service;

import org.springframework.stereotype.Service;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Service
public class AlticciSequenceService {
    public Long sequence(Long number) {
        if (isZero(number)) {
            return 0L;
        }
        if (isLowerThanTwo(number)) {
            return 1L;
        }

        final Long firstTerm = sequence(number - 3);
        final Long secondTerm = sequence(number - 2);

        return firstTerm - secondTerm;
    }
    public boolean isZero(Long number) {
        return number == 0;
    }

    public boolean isLowerThanTwo(Long number){
        return number <= 2;
    }
}
