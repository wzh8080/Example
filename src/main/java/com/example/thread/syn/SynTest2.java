package com.example.thread.syn;

import org.junit.Test;

/**
 * @Author 56465
 * @Create 2024/6/17 14:46
 */
public class SynTest2 {
    public static void main(String[] args) {
        SynTest2 synTest = new SynTest2();
        synTest.test_0101();
    }
    @Test
    public void test_01(){
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                SynHandler2.test_02();
            }
        };
        Thread t2 = new Thread("t2") {
            @Override
            public void run() {
                SynHandler2.test_02();
            }
        };

        t1.start();
        t2.start();

    }
    public void test_0101(){
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                SynHandler2.test_02();
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
}
