package com.example.pattern.structural.proxy.jdk;

import com.example.pattern.structural.proxy.business.BuyHouse;
import com.example.pattern.structural.proxy.business.BuyHouseImpl;

import java.lang.reflect.Proxy;

/**
 * @Author 56465
 * @Create 2024/5/22 16:11
 */
public class DynamicProxyDemo {
    public static void main(String[] args) {
        BuyHouse buyHouse = new BuyHouseImpl();
        BuyHouse proxyBuyHouse = (BuyHouse) Proxy.newProxyInstance(BuyHouse.class.getClassLoader(),
                new Class[]{BuyHouse.class},
                new DynamicProxyHandler(buyHouse));
        proxyBuyHouse.buyHosue();
    }
}