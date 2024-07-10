package com.example;

import java.math.BigDecimal;

/**
 * Author:King
 * Create:2024/6/13 12:33
 */
public class Demo extends Father{
    public static void main(String[] args) {
        BigDecimal d = new BigDecimal("123,123.12");
        System.out.println(d.toString());
        System.out.println(d.toPlainString());
    }

    public static void test1(){

    }
    public void test(){
        test1();
        show();
        staticShow();
        int[] a = {1,2,3};
        int[] b = new int[]{1,2,3};
        int[] b1 = new int[3];
    }
    @Override
    public void syncTest(){

    }
}
