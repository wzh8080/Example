package com.example.base;

/**
 * @Author zh wang
 * @Create 2024/12/9 19:38
 */
public class BaseDemo {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());

        FatherClass fatherClass = new SonClass();
        SonClass sonClass = new SonClass();
        System.out.println("fatherClass.name = " + fatherClass.name);
        System.out.println("fatherClass.staticName = " + fatherClass.staticName);
        System.out.println("sonClass.name = " + sonClass.name);
        System.out.println("sonClass.staticName = " + sonClass.staticName);
        System.out.println("sonClass.staticFatherName = " + sonClass.staticFatherName);
        System.out.println("SonClass.staticFatherName = " + SonClass.staticFatherName);
        fatherClass.show();
        fatherClass.showFinal();
        fatherClass.staticShow();
        fatherClass.staticShowFinal();
        fatherClass.syncTest();
    }
}
