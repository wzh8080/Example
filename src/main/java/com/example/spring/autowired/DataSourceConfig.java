package com.example.spring.autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

/**
 * 动态配置
 * @Author 56465
 * @Create 2024/6/11 15:46
 */
public class DataSourceConfig {

    //@Value("${db.type}")
    private String dbType;

    // 根据db.type的值动态决定主数据源
    @Bean
    @Profile("!mysql & !oracle") // 如果db.type不是mysql也不是oracle，则默认创建
    @Primary
    public DataSource defaultDataSource() {
        if ("mysql".equals(dbType)) {
            return dataSourceA();
        } else if ("oracle".equals(dbType)) {
            return dataSourceB();
        } else {
            throw new IllegalArgumentException("Unsupported db.type: " + dbType);
        }
    }

    // 根据条件创建DataSourceA
    @Bean
    @Profile("mysql") // 当db.type=mysql时创建
    public DataSource dataSourceA() {
        return new DataSourceA();
    }

    // 根据条件创建DataSourceB
    @Bean
    @Profile("oracle") // 当db.type=oracle时创建
    public DataSource dataSourceB() {
        return new DataSourceB();
    }
}
