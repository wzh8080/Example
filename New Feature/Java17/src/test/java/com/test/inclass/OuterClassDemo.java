package com.test.inclass;

/**
 * @Author 56465
 * @Create 2024/3/29 13:16
 */
public class OuterClassDemo {
    public class InnerClass {
        private static String NAME = "InnerClass";
        private static final int MAX = 10;
        private String name;

        record MyRecord() {
            public void someFunctionInRecord() {
                System.out.println(MAX);
            }
        }
    }
}
