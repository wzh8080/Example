package com.example.spring.autowired;

import com.example.base.FatherClass;

/**
 * Author:King
 * Create:2024/6/13 13:28
 */
public class Demo2 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Object name = FatherClass.class.getDeclaredField("name").get(null);
        Object name1 = FatherClass.class.getField("name").get(null);
        System.out.println(name);
        System.out.println(name1);

        FatherClass f = new FatherClass();
        Object name2 = f.getClass().getDeclaredField("name").get(f);
        Object name3 = f.getClass().getField("name").get(f);
        System.out.println(name2);
        System.out.println(name3);
    }
}
