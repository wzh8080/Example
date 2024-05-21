package com.example.pattern.structural.decorator;

import com.example.pattern.structural.decorator.intf.Coffee;

/**
 * 实现具体的装饰器类
 *
 * @Author 56465
 * @Create 2024/5/20 11:19
 */
public class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return super.cost() + 1.0;
    }

    @Override
    public String description() {
        return super.description() + ", with Milk";
    }
}