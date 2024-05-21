package com.example.pattern.structural.decorator;

import com.example.pattern.structural.decorator.intf.Coffee;

/**
 * 实现咖啡接口
 *
 * @Author 56465
 * @Create 2024/5/20 11:18
 */
public class SimpleCoffee implements Coffee {
    @Override
    public double cost() {
        return 2.0;
    }

    @Override
    public String description() {
        return "Simple Coffee";
    }
}