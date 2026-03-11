package com.hex.ddd.verification.infrastructure.adapters.out.persistence;

import com.hex.ddd.verification.domain.model.VerificationSession;
import com.hex.ddd.verification.domain.ports.out.VerificationRepository;
import org.springframework.stereotype.Component;

@Component
public class VerificationPersistenceAdapter implements VerificationRepository {

    private final SpringDataVerificationRepository repository;

    public VerificationPersistenceAdapter(SpringDataVerificationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(VerificationSession session) {
        VerificationEntity entity = new VerificationEntity(
            session.getId(),
            session.getUserId(),
            session.getStatus()
        );
        repository.save(entity);
    }
}