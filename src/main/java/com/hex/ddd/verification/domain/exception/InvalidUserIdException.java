package com.hex.ddd.verification.domain.exception;

public class InvalidUserIdException extends RuntimeException {
    public InvalidUserIdException(String s) {
        super(s);
    }
}
