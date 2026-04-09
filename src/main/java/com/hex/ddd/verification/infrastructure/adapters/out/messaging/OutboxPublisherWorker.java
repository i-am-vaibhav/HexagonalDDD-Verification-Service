package com.hex.ddd.verification.infrastructure.adapters.out.messaging;

import com.hex.ddd.verification.infrastructure.adapters.out.persistence.OutboxEvent;
import com.hex.ddd.verification.infrastructure.adapters.out.persistence.OutboxRepository;
import jakarta.transaction.Transactional;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OutboxPublisherWorker {

    private final OutboxRepository repository;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public OutboxPublisherWorker(OutboxRepository repository, KafkaTemplate<String, String> kafkaTemplate) {
        this.repository = repository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Transactional
    @Scheduled(fixedDelay = 2000)
    public void publishEvents() {

        List<OutboxEvent> events = repository.lockNextBatch(10);

        for (OutboxEvent event : events) {

            kafkaTemplate.send(event.getTopic(), event.getPayload());

            repository.updateStatusToSent(event.getId());
        }
    }
}