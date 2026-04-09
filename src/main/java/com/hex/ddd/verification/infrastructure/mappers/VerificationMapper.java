package com.hex.ddd.verification.infrastructure.mappers;

import com.hex.ddd.verification.domain.model.VerificationSession;
import com.hex.ddd.verification.infrastructure.adapters.out.persistence.VerificationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface VerificationMapper {
    @Mapping(target="userId", source="session.userId.userId")
    VerificationEntity toEntity(VerificationSession session);
}
