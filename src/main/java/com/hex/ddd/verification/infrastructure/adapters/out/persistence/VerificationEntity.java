package com.hex.ddd.verification.infrastructure.adapters.out.persistence;

import com.hex.ddd.verification.domain.model.VerificationStatus;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "verifications")
public class VerificationEntity {
    @Id
    private UUID id;

    private String userId;

    @Enumerated(EnumType.STRING)
    private VerificationStatus status;

    @Version
    private Long version;

    protected VerificationEntity() {}

    public VerificationEntity(UUID id, String userId, VerificationStatus status) {
        this.id = id;
        this.userId = userId;
        this.status = status;
    }
}