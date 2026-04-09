package com.hex.ddd.verification.infrastructure.adapters.out.persistence;

import com.hex.ddd.verification.domain.model.VerificationSession;
import com.hex.ddd.verification.infrastructure.mappers.VerificationMapper;
import com.hex.ddd.verification.infrastructure.mappers.VerificationMapperImpl;
import org.springframework.stereotype.Component;

@Component
public class VerificationPersistenceAdapter implements com.hex.ddd.verification.domain.ports.out.VerificationRepository {

    private final VerificationRepository repository;
    private final VerificationMapper verificationMapper;

    public VerificationPersistenceAdapter(VerificationRepository repository, VerificationMapper verificationMapper) {
        this.repository = repository;
        this.verificationMapper = verificationMapper;
    }

    @Override
    public void save(VerificationSession session) {
        repository.save(verificationMapper.toEntity(session));
    }
}