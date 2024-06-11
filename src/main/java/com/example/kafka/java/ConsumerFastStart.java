package com.example.kafka.java;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

/**
 * Kafka 消息消费者
 * Author:King
 * Create:2024/6/8 23:57
 */
public class ConsumerFastStart {
    // Kafka集群地址
    private static final String brokerList = "192.168.40.132:9092";
    // 主题名称-之前已经创建
    private static final String topic = "kafka-hello";
    // 消费组
    private static final String groupId = "group.demo1";

    public static void main(String[] args) {

        KafkaConsumer<String, String> consumer = getStringStringKafkaConsumer();
        // 订阅主题 这里使用了单元素集合Collections.singletonList确保只订阅一个主题。
        consumer.subscribe(Collections.singletonList(topic));

        while (true) {
            // 定期调用poll方法从Kafka集群拉取消费者分配到的消息，等待时间设为5秒（5000毫秒）
            // poll是Kafka消费者拉取数据的主要方法，它既可以获取消息，也能够维持消费者在群组中的活跃状态。
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1*1000));
            for (ConsumerRecord<String, String> record : records) {
                // 处理消息：对于每次poll返回的ConsumerRecords集合，
                // 通过增强型for循环遍历每条消息记录（ConsumerRecord<String, String>），
                // 并简单地打印出每条消息的值（record.value()）到控制台。
                System.out.println(record.value());
                try {
                    Thread.sleep(5*1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static KafkaConsumer<String, String> getStringStringKafkaConsumer() {
        Properties properties = new Properties();
        // 配置Bootstrap服务器，这是消费者寻找Kafka集群的入口点
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);
        // 设置键值反序列化器，这表明消费者期望接收到的消息键和值都是字符串格式。
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
        // 定义消费者组ID
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);//分组
        // 创建Kafka消费者实例，指定消息的键和值类型均为字符串。
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
        return consumer;
    }
}
