package com.example.thread.join;

import org.junit.Test;

public class JoinTest {
    @Test
    public void test_01() {
        TestRunnable r1 = new TestRunnable();
        TestRunnable r2 = new TestRunnable();
        Thread t1 = new Thread(r1, "t1");
        Thread t2 = new Thread(r2, "t2");
        t1.start();
        t2.start();

        try {
            System.out.println("开始监控t1");
            t1.join();
            System.out.println("t1结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("开始监控t2");
            t2.join();
            System.out.println("t2结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_02() {
        // 测试 join(xx) 方法，是否在规定时间没结束完成线程任务后，是否还会继续阻塞
        TestRunnable2 r1 = new TestRunnable2();
        Thread t1 = new Thread(r1, "t1");
        t1.start();
        try {
            System.out.println("开始监控t1");
            t1.join(10*1000);
            System.out.println("t1结束");
        } catch (InterruptedException e) {

        }
    }

    public void test(int q){
        try {
            Thread.sleep(3*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (q < 0) {
            throw new IllegalArgumentException("timeout value is negative");
        }else if (q < 1){
            throw new TestException("timeout value is negative");
        }
    }
}
