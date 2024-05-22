package com.example.pattern.structural.proxy.cglib;

import com.example.pattern.structural.proxy.business.BuyHouse;
import com.example.pattern.structural.proxy.business.BuyHouseImpl;

/**
 * @Author 56465
 * @Create 2024/5/22 16:06
 */
public class ProxyDemo {
    public static void main(String[] args){
        BuyHouse buyHouse = new BuyHouseImpl();
        CglibProxy cglibProxy = new CglibProxy();
        BuyHouseImpl buyHouseCglibProxy = (BuyHouseImpl) cglibProxy.getInstance(buyHouse);
        buyHouseCglibProxy.buyHosue();
    }
}
