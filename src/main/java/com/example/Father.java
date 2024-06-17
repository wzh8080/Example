package com.example;

/**
 * Author:King
 * Create:2024/6/13 12:33
 */
public class Father {
    public static String name = "父类";
    public static void staticShow(){
        System.out.println("父类静态方法");
    }
    public void show(){
        System.out.println("父类方法");
    }

    public synchronized void syncTest(){
        synchronized (this){
            System.out.println("父类同步方法");
        }
    }
}
