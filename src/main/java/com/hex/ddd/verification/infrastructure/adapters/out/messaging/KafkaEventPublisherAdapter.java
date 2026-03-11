package com.hex.ddd.verification.infrastructure.adapters.out.messaging;

import com.hex.ddd.verification.domain.ports.out.EventPublisherPort;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaEventPublisherAdapter implements EventPublisherPort {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "verification-events";

    public KafkaEventPublisherAdapter(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publishStatusChanged(String userId, String status) {
        // We publish the message to Kafka
        // Key is userId to ensure all events for one user go to the same partition (Order preservation!)
        kafkaTemplate.send(TOPIC, userId, "Status for user " + userId + " is now: " + status);
    }
}