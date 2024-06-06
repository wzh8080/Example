package com.example.pattern.structural.proxy.cglib;



import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author 56465
 * @Create 2024/5/22 15:09
 */
public class CglibProxy  implements MethodInterceptor {
    // 生成代理对象
    public Object getInstance(Class<?> clazz) {
        // 设置CGLIB输出代理类到指定目录
        String dir = "D:\\Workspace\\Example\\Java\\Example\\out\\temp"; // 替换为你想保存代理类的目录路径
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, dir);

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        // 设置回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }
    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        String methodName = method.getName();
        System.out.println("-------------- 判断方法名 --------------methodName="+methodName);
        Object result = null;
        if ("buyHouse".equals(methodName)) {
            System.out.println("methodName = " + methodName);
            System.out.println("买房前准备");
            //Object result = methodProxy.invoke(object, args);
            result = methodProxy.invokeSuper(object, args);   // 正确调用父类方法，避免直接递归
            System.out.println("买房后装修");
        }

            return result;
        }

}