package com.util.file;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 56465
 * @Create 2024/7/10 17:33
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        //FileCreator.clearDirectory("C:\\Users\\56465\\Desktop\\temp");

        //BigDecimal bigDecimal = new BigDecimal("-999");
        //double v = bigDecimal.setScale(4, RoundingMode.HALF_UP).doubleValue();
        //System.out.println("v = " + v);
        //
        //ArrayList<String> list = new ArrayList<>();
        //
        ////BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("a.txt"),"GBK"));
        //
        //HashMap<String, Integer> map = new HashMap<>();
        //System.out.println(map.get("1"));
        //
        //ArrayList<String> list1 = getList();
        //ArrayList<List<String>> lists = new ArrayList<>();
        //lists.add(list1);
        //list1 = getList();
        //lists.add(list1);
        //System.out.println(lists);

        List<Long> numbers = new ArrayList<>();
        numbers.add(null);
        numbers.add(null);
        numbers.add(null);
        // 使用 Stream API 进行累加操作
        long count = numbers.stream()
                .filter(n -> n != null).count();
        System.out.println("count = " + count);
        Long sum = numbers.stream()
                .filter(n -> n != null)
                .reduce(Long::sum).orElse(null);

        System.out.println("Sum: " + sum); // 输出：Sum: 36.0

    }

    private static ArrayList<String> getList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        return list;
    }

    // key = 发票代码+发票号码 ；value = 发票信息
    // { string: Element }
    public static void filteFpxx(List<Element> list) {
        for (Element ele : list) {
            // 剔除作废发票

        }
    }

    class Element {}
}
