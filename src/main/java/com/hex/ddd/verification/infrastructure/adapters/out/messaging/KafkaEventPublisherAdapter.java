package com.hex.ddd.verification.infrastructure.adapters.out.messaging;

import com.hex.ddd.verification.domain.events.VerificationCompletedEvent;
import com.hex.ddd.verification.domain.ports.out.EventPublisherPort;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
public class KafkaEventPublisherAdapter implements EventPublisherPort {

    private static final String TOPIC = "verification-events";

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public KafkaEventPublisherAdapter(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public void publishStatusChanged(VerificationCompletedEvent event) {
        try {
            String payload = objectMapper.writeValueAsString(event);

            kafkaTemplate.send(TOPIC, payload);

        } catch (Exception e) {
            throw new RuntimeException("Failed to serialize event", e);
        }
    }
}