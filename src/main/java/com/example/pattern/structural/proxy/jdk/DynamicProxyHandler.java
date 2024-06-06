package com.example.pattern.structural.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author 56465
 * @Create 2024/5/22 16:11
 */
public class DynamicProxyHandler implements InvocationHandler {
    private Object object;
    public DynamicProxyHandler(final Object object) {
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("判断方法名");
        if ("buyHouse".equals(method.getName())) {
            System.out.println("method = " + method.getName());
            System.out.println("买房前准备");
            result = method.invoke(object, args);
            System.out.println("买房后装修");
        }
        return result;
    }
}
