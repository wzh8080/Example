package com.app.kafka.demo.controller;

import com.app.kafka.service.KafkaExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhwang
 * @Create 2024/10/30 14:35
 */
@RestController
@RequestMapping("/kafka/test")
public class KafkaDemoController {

    @Autowired
    private KafkaExecutor kafkaExecutor;

    @Value("${kafka.topic}")
    private String topic;

    @RequestMapping(value = "/send", method = {RequestMethod.POST})
    public void sendMessage(@RequestParam String message) {
        kafkaExecutor.send(topic, message);
    }
}
