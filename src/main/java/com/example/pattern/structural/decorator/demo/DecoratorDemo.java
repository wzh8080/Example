package com.example.pattern.structural.decorator.demo;

import com.example.pattern.structural.decorator.MilkDecorator;
import com.example.pattern.structural.decorator.SimpleCoffee;
import com.example.pattern.structural.decorator.SugarDecorator;
import com.example.pattern.structural.decorator.intf.Coffee;

/**
 *   在这个示例中，Coffee 接口定义了基本的咖啡功能。SimpleCoffee 类实现了基本的咖啡。
 *   CoffeeDecorator 是装饰器的抽象类，它维护一个被装饰的咖啡对象。
 *   MilkDecorator 和 SugarDecorator 分别实现了具体的装饰器，通过在原始咖啡上添加新的功能。
 * @Author 56465
 * @Create 2024/5/20 11:21
 */
public class DecoratorDemo {
    public static void main(String[] args) {
        Coffee simpleCoffee = new SimpleCoffee();
        System.out.println("Cost: $" + simpleCoffee.cost() + ", Description: " + simpleCoffee.description());

        Coffee milkCoffee = new MilkDecorator(simpleCoffee);
        System.out.println("Cost: $" + milkCoffee.cost() + ", Description: " + milkCoffee.description());

        Coffee sugarMilkCoffee = new SugarDecorator(milkCoffee);
        System.out.println("Cost: $" + sugarMilkCoffee.cost() + ", Description: " + sugarMilkCoffee.description());
    }
}
