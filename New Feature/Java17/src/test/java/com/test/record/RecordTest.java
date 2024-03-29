package com.test.record;

import org.junit.Test;

/**
 * @Author 56465
 * @Create 2024/3/29 11:17
 */
public class RecordTest {
    @Test
    public void test01(){
        RecordDemo demo1 = new RecordDemo("张三", 14);
        RecordDemo demo2 = new RecordDemo("张三", 14);
        System.out.println("demo1.name() = " + demo1.name());
        System.out.println("demo1.equals(demo2) = " + demo1.equals(demo2));
        RecordDemo demo3 = new RecordDemo("张三", 14,"北京");
        System.out.println("demo3.getAddress() = " + demo3.getAddress());
        RecordDemo demo4 = new RecordDemo("张三", 14,"上海");
        System.out.println("demo3.equals(demo4) = " + demo3.equals(demo4)); // true

    }

}
