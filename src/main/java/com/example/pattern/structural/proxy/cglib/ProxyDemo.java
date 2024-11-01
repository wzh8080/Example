package com.example.pattern.structural.proxy.cglib;

import com.example.pattern.structural.proxy.business.BuyHouse;
import com.example.pattern.structural.proxy.business.BuyHouseImpl;
import org.springframework.cglib.core.DebuggingClassWriter;

/**
 * @Author 56465
 * @Create 2024/5/22 16:06
 */
public class ProxyDemo {
    public static void main(String[] args){
        BuyHouse buyHouse = new BuyHouseImpl();
        com.example.pattern.structural.proxy.cglib.CglibProxy cglibProxy = new com.example.pattern.structural.proxy.cglib.CglibProxy();
        BuyHouseImpl buyHouseCglibProxy = (BuyHouseImpl) cglibProxy.getInstance(buyHouse.getClass());
        buyHouseCglibProxy.buyHouse();
        System.out.println("----------------");
        buyHouseCglibProxy.buyCar();
        System.out.println("----------------");
        buyHouseCglibProxy.finalMethod();
    }
}
