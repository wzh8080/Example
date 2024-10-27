package com.example.thread.executor.config;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.concurrent.ExecutorService;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author zhwang
 * @Create 2024/10/25 15:58
 */
public class ExecutorConfigurationTest {
    @Autowired
    private ExecutorService executorService;

    @Test
    public void executorService() {
        //new ThreadPerTaskExecutor(executorService);
    }

}