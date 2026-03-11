package com.hex.ddd.verification.domain.model;

import java.util.UUID;

public class VerificationSession {
    private final UUID id;
    private final String userId;
    private final String documentNumber;
    private VerificationStatus status;

    public VerificationSession(String userId, String documentNumber){
        this.id = UUID.randomUUID();
        this.userId = userId;
        this.documentNumber = documentNumber;
        this.status = VerificationStatus.PENDING;
    }

    public void evaluate(boolean isDocumentValid){
        if (this.status != VerificationStatus.PENDING) {
            throw  new IllegalStateException(" evaluate a completed session.");
        }
        this.status = isDocumentValid ? VerificationStatus.SUCCESS : VerificationStatus.REJECTED;
    }

    public UUID getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public VerificationStatus getStatus() {
        return status;
    }
}
