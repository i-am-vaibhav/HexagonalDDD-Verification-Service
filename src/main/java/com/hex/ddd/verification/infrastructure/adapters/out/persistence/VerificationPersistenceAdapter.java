package com.hex.ddd.verification.infrastructure.adapters.out.persistence;

import com.hex.ddd.verification.domain.model.VerificationSession;
import org.springframework.stereotype.Component;

@Component
public class VerificationPersistenceAdapter implements com.hex.ddd.verification.domain.ports.out.VerificationRepository {

    private final VerificationRepository repository;

    public VerificationPersistenceAdapter(VerificationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(VerificationSession session) {
        VerificationEntity entity = new VerificationEntity(
            session.getId(),
            session.getUserId().userId(),
            session.getStatus()
        );
        repository.save(entity);
    }
}