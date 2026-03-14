package com.hex.ddd.verification.domain.strategy;

public interface VerificationStrategy {
    boolean supports(String documentType);
    boolean validate(String documentNumber);
}