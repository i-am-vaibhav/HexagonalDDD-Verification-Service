package com.hex.ddd.verification.infrastructure.adapters.in.messaging;

import com.hex.ddd.verification.domain.ports.in.StartVerificationUseCase;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UserCreatedAdapter {
    private final StartVerificationUseCase startVerificationUseCase;

    public UserCreatedAdapter(StartVerificationUseCase startVerificationUseCase) {
        this.startVerificationUseCase = startVerificationUseCase;
    }

    @KafkaListener(topics = "user-registration-events", groupId = "verification-service-group")
    public void onUserCreated(UserRegistrationEvent event){
        System.out.println("Received registration event for User: " + event.getUserId());
        startVerificationUseCase.handle(event.getUserId(), event.getDocumentNumber());
    }

}

