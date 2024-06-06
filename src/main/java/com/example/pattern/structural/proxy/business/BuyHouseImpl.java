package com.example.pattern.structural.proxy.business;

/**
 * @Author 56465
 * @Create 2024/5/22 16:08
 */
public class BuyHouseImpl implements BuyHouse {
    @Override
    public void buyHouse() {
        System.out.println("我要买房");
    }

    @Override
    public void buyCar() {
        System.out.println("我要买车");
    }

    private void privateMethod(){
        System.out.println("我是 private 方法");
    }
    public final void finalMethod(){
        System.out.println("我是final方法");
    }
}
