package com.hex.ddd.verification.infrastructure.adapters.out.messaging;

import com.hex.ddd.verification.domain.events.VerificationCompletedEvent;
import com.hex.ddd.verification.domain.ports.out.EventPublisherPort;
import com.hex.ddd.verification.infrastructure.adapters.out.persistence.OutboxEvent;
import com.hex.ddd.verification.infrastructure.adapters.out.persistence.OutboxRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.time.Instant;
import java.util.UUID;

@Component
public class KafkaEventPublisherAdapter implements EventPublisherPort {

    private static final String TOPIC = "verification-events";

    private final OutboxRepository repository;
    private final ObjectMapper objectMapper;

    public KafkaEventPublisherAdapter(OutboxRepository repository,
                                ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void publishStatusChanged(VerificationCompletedEvent event) {

        try {

            String payload = objectMapper.writeValueAsString(event);

            OutboxEvent outbox = new OutboxEvent(
                    UUID.randomUUID(),
                    "Verification",
                    event.getUserId(),
                    TOPIC,
                    payload,
                    "NEW",
                    Instant.now()
            );

            repository.save(outbox);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}