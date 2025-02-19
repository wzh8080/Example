package com.example.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhwang
 * @Create 2024/11/5 11:37
 */
public class StringDemo {
    public static void main(String[] args) {
        String a = "aaa";
        testStr(a);
        System.out.println("a = " + a);

        ArrayList<String> list = new ArrayList<>();
        list.add("111");
        testList(list);
        System.out.println("list = " + list);
    }
    public static String testStr(String str){
        str = "test";
        return str;
    }

    public static List<String> testList(List<String> list){
        list.add("test");
        return null;
    };
}
