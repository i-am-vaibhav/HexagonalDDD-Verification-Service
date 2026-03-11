package com.hex.ddd.verification.domain.ports.out;

public interface EventPublisherPort {
    void publishStatusChanged(String userId, String status);
}