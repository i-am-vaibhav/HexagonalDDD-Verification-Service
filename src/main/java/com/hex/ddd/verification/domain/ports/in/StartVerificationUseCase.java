package com.hex.ddd.verification.domain.ports.in;

public interface StartVerificationUseCase {
    void handle(String userId, String documentNumber);
}