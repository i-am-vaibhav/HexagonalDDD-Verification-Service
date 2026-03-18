package com.hex.ddd.verification.domain.model;

import com.hex.ddd.verification.domain.exception.InvalidDocumentNumber;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

public class DocumentNumber {

    @Getter
    String documentNumber;

    public DocumentNumber(String documentNumber){
        if (!StringUtils.isAlphanumeric(documentNumber)){
            throw new InvalidDocumentNumber();
        }
        this.documentNumber = documentNumber;
    }
}
