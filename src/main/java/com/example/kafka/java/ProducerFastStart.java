package com.example.kafka.java;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import java.util.Properties;

/**
 * Kafka 消息生产者
 * @Author: King
 * @Create: 2024/6/8 23:44
 */
public class ProducerFastStart {
    // Kafka集群地址
    private static final String brokerList = "192.168.40.132:9092";
    // 主题名称-之前已经创建
    private static final String topic = "kafka-hello";
    public static void main(String[] args) {

        Properties properties = new Properties();
        // 设置key序列化器
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        // 设置重试次数
        properties.put(ProducerConfig.RETRIES_CONFIG, 10);
        // 设置值序列化器
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        // 设置集群地址
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);
        // KafkaProducer
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
        //封装消息
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, "Kafka-demo-001", "hello, Kafka!");

        try {
            //发送消息
            producer.send(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        producer.close();
    }
}
