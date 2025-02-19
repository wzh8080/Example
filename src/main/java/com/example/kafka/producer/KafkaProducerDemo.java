package com.example.kafka.producer;

import com.util.DateUtil;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.HashMap;

/**
 * @Author 56465
 * @Create 2024/10/24 13:18
 */
public class KafkaProducerDemo {
    public static void main(String[] args) {
        // 配置信息
        HashMap<String, Object> configMap = new HashMap<>();
        configMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.126.100:9092");
        // key和value的序列化
        configMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        configMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // 创建生产者
        KafkaProducer<String, String> producer = new KafkaProducer<>(configMap);

        // 创建消息
        for (int i = 0; i < 10; i++) {
            String now = DateUtil.getNowTime();
            ProducerRecord<String, String> record =
                    new ProducerRecord<>("topic-test",
                            now + " key-test-" + i,
                            now + " val-test-" + i);
            // 发送消息
            producer.send(record);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // 关闭生产者
        producer.close();
        System.out.println("生产者关闭");

    }
}
