package com.example.time;


import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

/**
 * @Author zh wang
 * @Create 2024/12/2 20:52
 */
@SpringBootTest
public class TimeDemo {
    // 365天
    int a ;
    Integer b;
    static boolean c;
    @Test
    public void test1(){
        int i = LocalDate.now().lengthOfYear();
        System.out.println("i = " + i);

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);

        String t1 = TestA.t1;
    }
    private String str = "";
    class A{
        public void test(){
            System.out.println("A");
            System.out.println(str);
        }
    }
}
