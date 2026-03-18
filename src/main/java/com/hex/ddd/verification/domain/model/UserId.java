package com.hex.ddd.verification.domain.model;

import com.hex.ddd.verification.domain.exception.InvalidUserIdException;
import org.apache.commons.lang3.StringUtils;

public record UserId(String userId) {
    public UserId {
        if (StringUtils.isBlank(userId)){
            throw new InvalidUserIdException("Must not be null or blank");
        }
        if (!StringUtils.isAlphanumeric(userId)) {
            throw new InvalidUserIdException("Must be alpha numeric");
        }
    }
}
