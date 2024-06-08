package com.example.pattern.behavioral.command;

/**
 * 实现者
 * @Author 56465
 * @Create 2024/6/6 10:53
 */
public class Light {
    String loc = "";

    public Light(String loc) {
        this.loc = loc;
    }
    public void On() {
        System.out.println(loc + " On");
    }
    public void Off() {
        System.out.println(loc + " Off");
    }
}
