package com.example.thread.syn;

import org.junit.Test;

/**
 * @Author 56465
 * @Create 2024/6/17 14:46
 */
public class SynTest {
    public static void main(String[] args) {
        SynTest synTest = new SynTest();
        synTest.test_06();
    }
    @Test
    public void test_01(){
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                SynHandler.test_02();
            }
        };
        Thread t2 = new Thread("t2") {
            @Override
            public void run() {
                SynHandler.test_02();
            }
        };

        t1.start();
        t2.start();

    }
    public void test_02(){
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                new SynHandler().test_01();
            }
        };
        Thread t2 = new Thread("t2") {
            @Override
            public void run() {
                new SynHandler().test_01();
            }
        };

        t1.start();
        t2.start();
    }
    public void test_0201(){
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                new SynHandler().test_02();
            }
        };
        Thread t2 = new Thread("t2") {
            @Override
            public void run() {
                new SynHandler().test_02();
            }
        };

        t1.start();
        t2.start();
    }

    /**
     * 测试 SynHandler().test_03()
     * synchronized 修饰实例方法
     * 锁对象不同，所以可以同时执行
     */
    public void test_03(){
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                new SynHandler().test_03();
            }
        };
        Thread t2 = new Thread("t2") {
            @Override
            public void run() {
                new SynHandler().test_03();
            }
        };
        t1.start();
        t2.start();
    }
    /**
     * 测试 SynHandler().test_03()
     * synchronized 修饰实例方法
     * 锁对象相同，所以只能同时执行一个
     */
    public void test_04(){
        SynHandler handler = new SynHandler();
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                handler.test_03();
            }
        };
        Thread t2 = new Thread("t2") {
            @Override
            public void run() {
                handler.test_03();
            }
        };
        t1.start();
        t2.start();
    }
    /**
     * 测试 SynHandler().test_04()
     * synchronized 修饰静态方法
     */
    public void test_05(){
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                SynHandler.test_04();
            }
        };
        Thread t2 = new Thread("t2") {
            @Override
            public void run() {
                SynHandler.test_04();
            }
        };
        t1.start();
        t2.start();
    }

    /**
     * 实现多线程的累加
     * 错误：count lambda 表达式中使用的变量应为 final 或 有效 final
     */
    public void test_06(){
        Integer count = 0;
        count = count+1;
        while (true) {
            if (count >= 100) {
                break;
            }
            Integer finalCount = count;
            new Thread(()->{
                SynHandler.test_05(finalCount);
            }).start();
        }
    }
    volatile Integer count = 0;
    public void test_07(){
        while (true) {
            if (count >= 100) {
                break;
            }
            new Thread(()->{
                SynHandler.test_05(count);
            }).start();
        }
    }
}
