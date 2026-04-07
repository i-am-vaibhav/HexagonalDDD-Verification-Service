package com.hex.ddd.verification.infrastructure.adapters.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface OutboxRepository extends JpaRepository<OutboxEvent, UUID> {

    @Query(value = """
        SELECT * FROM outbox_events
        WHERE status = 'NEW'
        FOR UPDATE SKIP LOCKED
        LIMIT :batchSize
        """, nativeQuery = true)
    List<OutboxEvent> lockNextBatch(int batchSize);

    @Query(value = """
        UPDATE outbox_events SET STAUS = 'SENT'
        WHERE id = :id
        FOR UPDATE SKIP LOCKED
        LIMIT 1
        """, nativeQuery = true)
    void updateStatusToSent(UUID id);
}