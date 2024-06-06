package com.example.pattern.structural.proxy.cglib.test;

/**
 * @Author 56465
 * @Create 2024/6/3 14:15
 */
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class PrivateMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        // 如果是publicMethod调用，则通过反射调用其内部的privateMethod，并在前后添加额外逻辑
        if ("publicMethod".equals(method.getName())) {
            // 使用反射访问私有方法
            Method privateMethod = TargetClass.class.getDeclaredMethod("privateMethod", String.class);
            privateMethod.setAccessible(true); // 突破私有权限

            // 在调用前的逻辑
            System.out.println("Before calling private method.");

            // 调用私有方法
            Object result = privateMethod.invoke(obj, args[0]);

            // 在调用后的逻辑
            System.out.println("After calling private method.");

            return result;
        } else {
            return proxy.invokeSuper(obj, args);
        }
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TargetClass.class);
        enhancer.setCallback(new PrivateMethodInterceptor());

        TargetClass proxyInstance = (TargetClass) enhancer.create();
        System.out.println(proxyInstance.publicMethod("Hello World"));
    }
}