package com.example.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author 56465
 * @Create 2024/10/24 13:28
 */
public class KafkaConsumerDemo2 {
    public static void main(String[] args) {
        // 配置
        HashMap<String, Object> configMap = new HashMap<>();
        configMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.126.100:9092");
        // key和value的反序列化
        configMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        configMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        configMap.put(ConsumerConfig.GROUP_ID_CONFIG, "test-group-1");
        configMap.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");


        // 创建消费者
        KafkaConsumer consumer = new KafkaConsumer(configMap);

        // 订阅主题
        consumer.subscribe(Arrays.asList("topic-test"));

        while (true) {
            // 拉取数据
            ConsumerRecords records = consumer.poll(100);
            for (Object record : records) {
                System.out.println("record==="+record);
            }
        }
    }
}
