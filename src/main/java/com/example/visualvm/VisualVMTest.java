package main.java.com.example.visualvm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 56465
 * @Create 2024/8/13 15:55
 */
public class VisualVMTest {
    public static void main(String[] args) {
        test02();
    }

    public static void test01() {
        while (true) {
            System.out.println("test");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static List list = new ArrayList<Map<Object, Object>>();
    public static void test02() {
        for (int i = 0; i < 10000; i++){
            list.add(new HashMap<>(100));
            System.out.println("i==="+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
