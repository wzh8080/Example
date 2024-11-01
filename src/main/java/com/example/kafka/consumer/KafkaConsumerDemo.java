package com.example.kafka.consumer;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author 56465
 * @Create 2024/10/24 13:28
 */
public class KafkaConsumerDemo {
    public static void main(String[] args) {
        // 配置
        HashMap<String, Object> configMap = new HashMap<>();
        configMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.126.100:9092");
        // key和value的反序列化
        configMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        configMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        configMap.put(ConsumerConfig.GROUP_ID_CONFIG, "test-group-1");
        configMap.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        // 自动提交
        //configMap.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        //configMap.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, 5000);
        // 手动提交
        configMap.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);


        // 创建消费者
        KafkaConsumer consumer = new KafkaConsumer(configMap);

        // 订阅主题
        consumer.subscribe(Arrays.asList("topic-test"));

        TopicPartition partition = new TopicPartition("topic-test", 0); // 替换为你的分区
        OffsetAndMetadata committedOffset = consumer.committed(partition);
        if (committedOffset != null) {
            long offset = committedOffset.offset();
            System.out.println("已提交的偏移量 Committed offset: " + offset);
        } else {
            System.out.println("committedOffset 是 null.");
        }

        while (true) {
            // 拉取数据
            ConsumerRecords records = consumer.poll(100);
            int i = 1;
            for (Object record : records) {
                System.out.println("record==="+record);
                //i++;
                //if (i > 20) {
                //    consumer.commitSync();
                //}

            }

            if (committedOffset != null) {
                long offset = committedOffset.offset();
                System.out.println("已提交的偏移量 Committed offset: " + offset);
            } else {
                System.out.println("committedOffset 是 null.");
            }
        }
    }
}
