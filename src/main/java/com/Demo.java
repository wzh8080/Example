package com;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author 56465
 * @Create 2024/7/11 14:41
 */
public class Demo {
    public static void main(String[] args) {
        BigDecimal bd = new BigDecimal(0.1f);
        System.out.println("bd: " + bd);

        BigDecimal bd2 = BigDecimal.valueOf(0.1f);
        System.out.println("bd2: " + bd2);

        BigDecimal bd3 = new BigDecimal(String.valueOf(0.1f));
        System.out.println("bd3: " + bd3); // 显示为0.1

        BigDecimal bd4 = new BigDecimal(0.1d);
        System.out.println("bd4: " + bd4);

        BigDecimal bd5 = BigDecimal.valueOf(0.1d);
        System.out.println("bd5: " + bd5); // 显示为0.1


        double d = bd.doubleValue();
        // 使用更高精度的打印来检查double的实际值
        System.out.printf("The actual double value is: %.30f\n", d);

        // 将集合中对象取出后，对取出的对象进行修改，原集合是否会改变？final？
        // 字符串是不可变的，所以对字符串进行修改，不会影响原字符串
        // 集合中对象是可变的，所以对取出的对象进行修改，原集合会改变
        ArrayList<String> list = new ArrayList<>();
        list.add("床前明月光");
        list.add("疑是地上霜");
        list.add("举头望明月");
        list.add("低头思故乡");
        String s = list.get(1);
        System.out.println("s = " + s);
        s = "测试";
        s = s+"66";
        list.forEach(System.out::println);
        System.out.println("------------");

        ArrayList<StringBuilder> list2 = new ArrayList<StringBuilder>();
        list2.add(new StringBuilder("床前明月光"));
        list2.add(new StringBuilder("疑是地上霜"));
        list2.add(new StringBuilder("举头望明月"));
        list2.add(new StringBuilder("低头思故乡"));
        StringBuilder sb = list2.get(1);
        sb.append("测试");
        list2.forEach(System.out::println);
        System.out.println("------------");

        String s1 = "床前明月光，疑是地上霜";
        String s2 = s1.substring(s1.indexOf("月光"));
        System.out.println("s2 = " + s2);

        String t1 = "123456";
        String t2 = getTest(t1);
        System.out.println("t1 = " + t1);
        System.out.println("t2 = " + t2);

        HashMap<String, String> map = new HashMap<>();
        map.put(null, "1");
        map.put(null, null);
        map.put("2", "2");
        System.out.println("map = " + map);
        System.out.println("map = " + map.size());

        System.out.println("------------");
        HashSet<String> set = new HashSet<>();
        set.add("1");
        set.add(null);
        System.out.println("set = " + set);
        System.out.println("set = " + set.size());
        System.out.println("------------");

        List<String> list1 = new ArrayList<>();
        list1.add("");
        String join = String.join(",", list1);
        System.out.println("join ="+join+"--" + join.equals(""));

    }

    private static String getTest(String t1) {
        t1 = "666";
        return t1;
    }
}
