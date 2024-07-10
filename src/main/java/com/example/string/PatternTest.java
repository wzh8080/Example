package com.example.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author 56465
 * @Create 2024/7/9 11:44
 */
public class PatternTest {

    public static void main(String[] args) {
        String regex = "\\{#(\\d+)}";
        String temp = "123{#2}1{#3}23";
        test_01(regex, temp);
    }
    public static void test_01(String regex, String temp){
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(temp);
        //boolean isMatch = matcher.matches();    // 整个匹配
        //System.out.println("isMatch = " + isMatch);
        // 部分匹配
        while (matcher.find()){
            System.out.println(matcher.group());
            System.out.println(matcher.group(1));
        }

    }

}
