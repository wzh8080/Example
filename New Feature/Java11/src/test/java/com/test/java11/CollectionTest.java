package com.test.java11;

import org.junit.Test;

import java.util.List;

/**
 * JDK 11对于集合API的增强
 * @Author 56465
 * @Create 2024/3/28 15:32
 */
public class CollectionTest {
    @Test
    public void test01(){
        // 1.创建一个不可变集合对象
        List<String> names = List.of("猪八戒","猪刚鬣","唐僧");
        System.out.println(names);
        // names.add("孙悟空");

        // 2.可以把List集合转换成对应元素的类型
        // Object[] arrs1 = names.toArray();
        // JDK 11之前的方案
        //String[] arrs1 = names.toArray(new String[0]);
        // JDK 11之后的方法
        String[] arrs1 = names.toArray(String[]::new);
    }
}
