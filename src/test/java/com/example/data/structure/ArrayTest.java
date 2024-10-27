package com.example.data.structure;

import org.junit.Test;

import java.util.Arrays;

/**
 * 数据结构: 数组
 *
 * @Author 56465
 * @Create 2024/10/23 11:06
 */
public class ArrayTest {
    @Test
    public void test() {
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = new int[]{};
        int[] arr3 = new int[5];
        System.out.println(arr1[2]);
        System.out.println(Arrays.toString(arr3));
    }
}
