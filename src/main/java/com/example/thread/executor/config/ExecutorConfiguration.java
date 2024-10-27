package com.example.thread.executor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author zhwang
 * @Create 2024/10/25 15:55
 */
@Configuration
public class ExecutorConfiguration {
    @Bean
    public ExecutorService executorService() {
        return new ThreadPoolExecutor(2,
                5, 60L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10));
    }
}
