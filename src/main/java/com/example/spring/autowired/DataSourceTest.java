package com.example.spring.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author 56465
 * @Create 2024/6/11 15:36
 */
@Service
public class DataSourceTest{
    // 多个相同类型对象时：
    //@Autowired
    //@Qualifier("dataSourceA")
    //private DataSource dataSource;

    // 可行
    //@Autowired
    //private DataSource dataSourceA;

    // 不行
    //private final DataSource dataSource;
    //public DataSourceTest(DataSource dataSource) {
    //    this.dataSource = dataSource;
    //}

    // 可行
    //private final DataSource dataSourceA;
    //public DataSourceTest(DataSource dataSourceA) {
    //    this.dataSourceA = dataSourceA;
    //}


    //private final DataSource dataSource;
    //
    //public DataSourceTest(DataSource dataSource) {
    //    System.out.println("------"+dataSource.getClass().getName());
    //    this.dataSource = dataSource;
    //}




}
