package com.hex.ddd.verification.infrastructure.adapters.in.messaging;

import com.hex.ddd.verification.domain.ports.in.StartVerificationUseCase;
import com.hex.ddd.verification.infrastructure.adapters.in.dto.VerificationRequest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UserCreatedAdapter {
    private final StartVerificationUseCase startVerificationUseCase;

    public UserCreatedAdapter(StartVerificationUseCase startVerificationUseCase) {
        this.startVerificationUseCase = startVerificationUseCase;
    }

    @KafkaListener(topics = "user-verification-events", groupId = "verification-service-group")
    public void onUserCreated(VerificationRequest event){
        System.out.println("Received registration event for User: " + event.getUserId());
        startVerificationUseCase.handle(event.getUserId(), event.getDocumentNumber());
    }

}

