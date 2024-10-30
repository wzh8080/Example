package com.app.kafka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;


/**
 * @Author zhwang
 * @Create 2024/10/30 14:20
 */
@Component
@Slf4j
public class KafkaExecutor {

    private final KafkaTemplate kafkaTemplate;

    public KafkaExecutor(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String topic, String message) {
        log.info("send message: {}", message);
        ListenableFuture future = kafkaTemplate.send(topic, message);
        future.addCallback(new ListenableFutureCallback<SendResult>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("send message error: {}, message={}", ex.getMessage(), message);
            }

            @Override
            public void onSuccess(SendResult result) {
                log.trace("send message success: offset={}, message={}",
                        result.getRecordMetadata().offset(),
                        message);
            }
        });
    }
}
