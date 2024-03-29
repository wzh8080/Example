package com.test.java12;

import org.junit.Test;

/**
 * @Author 56465
 * @Create 2024/3/28 17:35
 */
public class StringTest {
    @Test
    public void test01(){
        var rs = "itheima".transform(s -> s +"学习Java!").transform(s -> s.toUpperCase());
        System.out.println(rs);
    }

    /**
     * 缩进
     */
    @Test
    public void test02(){
        System.out.println("=======================");
        var rs1 = "A\nBBBB\bC\n".indent(3);
        System.out.println(rs1);
        System.out.println("=======================");
        System.out.println("A\nBBBB\bC\n");
        System.out.println("=======================");
    }
}
