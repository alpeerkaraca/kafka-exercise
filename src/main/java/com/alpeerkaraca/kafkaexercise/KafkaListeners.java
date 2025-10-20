package com.alpeerkaraca.kafkaexercise;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "test-topic", groupId = "${spring.kafka.consumer.group-id}")

    void listener(String message) {
        System.out.println("Listener Received Message: " + message + "🍾");
    }
}
