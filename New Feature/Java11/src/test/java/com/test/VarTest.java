package com.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @Author 56465
 * @Create 2024/3/28 15:11
 */
public class VarTest {
    @Test
    public void test01(){
        var map = new HashMap<String, Integer>();
        map.put("a", 1);
        map.put("b", 2);
        for (var entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + ":" + value);
        }
    }

    /**
     * Java 10 明隐式类型的lambda表达式的形参时，还不允许使用 var
     */
    @Test
    public void test02(){
        List<Integer> nums = new ArrayList<>();
        Collections.addAll(nums ,9 , 10 , 3);
        nums.sort(( o2 ,  o1) -> o2 - o1);
        // Java 11 才开始支持
        nums.sort((@Deprecated var o2 , @Deprecated var o1) -> o2 - o1);
        System.out.println(nums);
    }
}
