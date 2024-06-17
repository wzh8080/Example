package com.example.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:King
 * Create:2024/6/9 16:03
 */
//@RestController
public class KafkaController {

    //@Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessageToKafka(@RequestBody String message) {
        kafkaProducerService.sendMessage("my-topic", message);
        return ResponseEntity.ok("Message '" + message + "' sent to Kafka");
    }
}