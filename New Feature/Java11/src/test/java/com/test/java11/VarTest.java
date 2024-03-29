package com.test.java11;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author 56465
 * @Create 2024/3/28 15:19
 */
public class VarTest {
    @Test
    public void test01(){
        List<Integer> nums = new ArrayList<>();
        Collections.addAll(nums ,9 , 10 , 3);
        //nums.sort(( o2 ,  o1) -> o2 - o1);
        nums.sort((@Deprecated var o2 , @Deprecated var o1) -> o2 - o1);
        System.out.println(nums);
    }
}
