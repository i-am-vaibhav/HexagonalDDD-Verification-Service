package com.hex.ddd.verification.infrastructure.adapters.out.messaging;

import com.hex.ddd.verification.domain.events.VerificationCompletedEvent;
import com.hex.ddd.verification.domain.ports.out.EventPublisherPort;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
public class KafkaEventPublisherAdapter implements EventPublisherPort {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "verification-events";
    private ObjectMapper objectMapper = new ObjectMapper();

    public KafkaEventPublisherAdapter(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publishStatusChanged(VerificationCompletedEvent event) {
        kafkaTemplate.send(TOPIC, event.getUserId(), objectMapper.writeValueAsString(event));
    }
}