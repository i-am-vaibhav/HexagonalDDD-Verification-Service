package com.hex.ddd.verification.infrastructure.adapters.out.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "outbox_events")
@Getter
public class OutboxEvent {

    @Id
    private UUID id;

    private String aggregateType;
    private String aggregateId;
    private String topic;

    @Column(columnDefinition = "TEXT")
    private String payload;

    @Setter
    private String status;

    private Instant createdAt;

    public OutboxEvent() {}

    public OutboxEvent(UUID uuid, String aggregateType, String aggregateId, String topic, String payload, String status, Instant createdAt) {
        this.id = uuid;
        this.aggregateType = aggregateType;
        this.aggregateId = aggregateId;
        this.topic = topic;
        this.payload = payload;
        this.status = status;
        this.createdAt = createdAt;
    }

}