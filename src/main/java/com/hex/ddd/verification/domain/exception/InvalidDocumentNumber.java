package com.hex.ddd.verification.domain.exception;

public class InvalidDocumentNumber extends RuntimeException {
    public InvalidDocumentNumber(String message) {
        super(message);
    }
}
