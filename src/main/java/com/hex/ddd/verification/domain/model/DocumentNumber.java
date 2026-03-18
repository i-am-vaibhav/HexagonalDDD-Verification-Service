package com.hex.ddd.verification.domain.model;

import com.hex.ddd.verification.domain.exception.InvalidDocumentNumber;
import org.apache.commons.lang3.StringUtils;

public record DocumentNumber(String documentNumber) {

    public DocumentNumber {
        if (StringUtils.isBlank(documentNumber)){
            throw new InvalidDocumentNumber("Must not be null or blank");
        }
        if (!StringUtils.isAlphanumeric(documentNumber)) {
            throw new InvalidDocumentNumber("Must be alpha numeric");
        }
    }
}
