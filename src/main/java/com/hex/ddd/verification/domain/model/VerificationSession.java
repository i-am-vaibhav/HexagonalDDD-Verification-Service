package com.hex.ddd.verification.domain.model;

import lombok.Getter;

import java.util.UUID;

@Getter
public class VerificationSession {
    private final UUID id;
    private final UserId userId;
    private final DocumentNumber documentNumber;
    private VerificationStatus status;

    public VerificationSession(UserId userId, DocumentNumber documentNumber){
        this.id = UUID.randomUUID();
        this.userId = userId;
        this.documentNumber = documentNumber;
        this.status = VerificationStatus.PENDING;
    }

    public void evaluate(boolean isDocumentValid){
        if (this.status != VerificationStatus.PENDING) {
            throw  new IllegalStateException("Don't evaluate a completed session.");
        }
        this.status = isDocumentValid ? VerificationStatus.SUCCESS : VerificationStatus.REJECTED;
    }

}
