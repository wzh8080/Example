package com.example.pattern.structural.proxy.cglib.test;

/**
 * @Author 56465
 * @Create 2024/6/3 14:15
 */
public class TargetClass {
    private String privateMethod(String input) {
        System.out.println("我是私有方法");
        return "Private method called with: " + input;
    }

    public String publicMethod(String input) {
        System.out.println("我是公共方法");
        return "公共方法"; // 公共方法调用私有方法
    }
}
