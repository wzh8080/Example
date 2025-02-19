package com.util;

/**
 * @Author zh wang
 * @Create 2024/11/8 14:17
 */
public class StringUtil {
    public static void main(String[] args) {
        System.out.println(isEmpty(""));
        System.out.println(isEmpty("   "));
        System.out.println(isSpace(""));
        System.out.println(isSpace("   "));
    }
    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
    public static boolean isSpace(String str) {
        return str == null || str.trim().isEmpty();
    }
}
