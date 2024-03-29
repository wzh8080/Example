package com.test.instance;

import org.junit.Test;

/**
 * @Author 56465
 * @Create 2024/3/29 13:39
 */
public class InstanceOfTest {
    @Test
    public void test01(){
        Object obj = "Hello";
        if (obj instanceof String str) {
            // can use str here
            System.out.println(str.length());
        } else {
            // can't use str here
            System.out.println("not a string");
        }
    }
}
