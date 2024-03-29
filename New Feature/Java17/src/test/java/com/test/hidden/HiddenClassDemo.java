package com.test.hidden;

/**
 * 隐藏类
 * @Author 56465
 * @Create 2024/3/29 17:14
 */
public class HiddenClassDemo {
    public static void main(String[] args) {
        Runnable run1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World 1");
            }
        };

        //Runnable run2 = () -> System.out.println("Hello World 2");
        //
        //System.out.println("End");
    }
}
