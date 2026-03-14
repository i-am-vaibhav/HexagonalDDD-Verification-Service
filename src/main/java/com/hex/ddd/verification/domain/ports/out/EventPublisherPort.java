package com.hex.ddd.verification.domain.ports.out;

import com.hex.ddd.verification.domain.events.VerificationCompletedEvent;

public interface EventPublisherPort {
    void publishStatusChanged(VerificationCompletedEvent event);
}