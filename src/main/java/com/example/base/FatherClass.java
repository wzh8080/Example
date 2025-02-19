package com.example.base;

/**
 * Author:King
 * Create:2024/6/13 12:33
 */
public class FatherClass {
    public static String staticFatherName = "父类静态属性：staticFatherName";
    public static String staticName = "父类静态属性：staticName";
    public String name = "父类实例属性：name";
    public void show(){
        System.out.println("父类实例方法");
    }
    public final void showFinal(){
        System.out.println("父类 final 实例方法");
    }
    public static void staticShow(){
        System.out.println("父类静态方法");
    }
    public final static void staticShowFinal(){
        System.out.println("父类 final 静态方法");
    }

    public synchronized void syncTest(){
        synchronized (this){
            System.out.println("父类同步方法");
        }
    }
}
