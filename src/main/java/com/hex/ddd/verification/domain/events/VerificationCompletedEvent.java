package com.hex.ddd.verification.domain.events;

import com.hex.ddd.verification.domain.model.VerificationStatus;

import java.util.UUID;

public class VerificationCompletedEvent {

    private final UUID verificationId;
    private final String userId;
    private final VerificationStatus status;

    public VerificationCompletedEvent(
            UUID verificationId,
            String userId,
            VerificationStatus status) {

        this.verificationId = verificationId;
        this.userId = userId;
        this.status = status;
    }

    public UUID getVerificationId() { return verificationId; }
    public String getUserId() { return userId; }
    public VerificationStatus getStatus() { return status; }
}