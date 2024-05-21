package com.example.pattern.structural.decorator;

import com.example.pattern.structural.decorator.intf.Coffee;

/**
 * 装饰器抽象类
 *
 * @Author 56465
 * @Create 2024/5/20 11:19
 */
public abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost();
    }

    @Override
    public String description() {
        return decoratedCoffee.description();
    }
}
