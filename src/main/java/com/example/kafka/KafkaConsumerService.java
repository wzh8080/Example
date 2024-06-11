package com.example.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * 消费者
 * Author:King
 * Create:2024/6/9 15:58
 */
@Service
public class KafkaConsumerService {
    @KafkaListener(topics = "my-topic", groupId = "my-group-id")
    public void listen(String message) {
        // 消费消息
        System.out.println("Received message: " + message);
    }
}
