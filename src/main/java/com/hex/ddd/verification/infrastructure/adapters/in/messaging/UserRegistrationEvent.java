package com.hex.ddd.verification.infrastructure.adapters.in.messaging;

import lombok.Getter;

@Getter
class UserRegistrationEvent {
    private String userId;
    private String documentNumber;
}
