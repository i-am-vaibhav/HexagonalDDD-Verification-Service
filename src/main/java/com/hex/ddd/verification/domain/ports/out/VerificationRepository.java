package com.hex.ddd.verification.domain.ports.out;

import com.hex.ddd.verification.domain.model.VerificationSession;

public interface VerificationRepository {
    void save(VerificationSession session);
}