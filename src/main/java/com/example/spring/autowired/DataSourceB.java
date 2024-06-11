package com.example.spring.autowired;

import org.springframework.stereotype.Component;

/**
 * @Author 56465
 * @Create 2024/6/11 15:36
 */
public class DataSourceB implements DataSource {
    public DataSourceB() {
        System.out.println("DataSourceB 初始化");
    }
    @Override
    public void connect() {
        System.out.println("Connected to DataSource B");
    }
}
