package com.app.kafka.demo.listener;

import com.app.kafka.config.KafkaConfiguration;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Kafka 监听
 * @Author zhwang
 * @Create 2024/10/30 14:40
 */
@Component
public class KafkaConsumerListener {

    @KafkaListener(id = "my-group-id",
            //topics = "${kafka.topic}",
            topics = KafkaConfiguration.TOPIC,
            groupId = "${kafka.group-id}")
    public void onMessage(List<ConsumerRecord> recordList, Acknowledgment ack){
        System.out.println("消费者监听... Start");
        recordList.forEach(record -> System.out.println("消费消息: "+record.value()));
        System.out.println("消费者监听... End");
    }
}
