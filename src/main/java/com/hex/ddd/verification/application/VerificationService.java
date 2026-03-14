package com.hex.ddd.verification.application;

import com.hex.ddd.verification.domain.events.VerificationCompletedEvent;
import com.hex.ddd.verification.domain.model.VerificationSession;
import com.hex.ddd.verification.domain.ports.in.StartVerificationUseCase;
import com.hex.ddd.verification.domain.ports.out.EventPublisherPort;
import com.hex.ddd.verification.domain.ports.out.IdentityVendorPort;
import com.hex.ddd.verification.domain.ports.out.VerificationRepository;
import org.springframework.stereotype.Service;

@Service
public class VerificationService implements StartVerificationUseCase {

    private final VerificationRepository verificationRepository;
    private final IdentityVendorPort identityVendorPort;
    private final EventPublisherPort eventPublisherPort;

    public VerificationService(VerificationRepository verificationRepository, IdentityVendorPort identityVendorPort, EventPublisherPort eventPublisherPort) {
        this.verificationRepository = verificationRepository;
        this.identityVendorPort = identityVendorPort;
        this.eventPublisherPort = eventPublisherPort;
    }

    @Override
    public void handle(String userId, String documentNumber) {

        VerificationSession verificationSession = new VerificationSession(userId, documentNumber);

        boolean isDocValid = identityVendorPort.isValid(documentNumber);

        verificationSession.evaluate(isDocValid);

        verificationRepository.save(verificationSession);

        VerificationCompletedEvent event =
                new VerificationCompletedEvent(verificationSession.getId(), userId, verificationSession.getStatus());

        eventPublisherPort.publishStatusChanged(event);

    }

}
