package com.example.thread.wait;

import com.example.thread.ThreadUtil;
import org.junit.Test;

public class Demo {
    @Test
    public void test_01(){
        TestHandler h = new TestHandler();

        Thread t2 = new Thread("t2") {
            public void run() {
                System.out.println(ThreadUtil.getThreadName() + "进入线程");
                try {
                    Thread.sleep(2 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(ThreadUtil.getThreadName() + "开始 --- notify");
                synchronized (h) {
                    h.notify();
//                    notifyAll();
//                    h.notifyAll();
                    System.out.println(ThreadUtil.getThreadName() + "开始 --- 获取了 锁 h");
                }
                System.out.println(ThreadUtil.getThreadName() + "结束 --- notify");
            }
        };
        t2.start();


        Thread t1 = new Thread("t1") {
            public void run() {
                System.out.println(ThreadUtil.getThreadName() + "进入线程");
                h.test();
            }
        };
        t1.start();

        System.out.println("当前线程数："+ Thread.activeCount());

        h.test();

        System.out.println("main线程结束1");
        try {
            Thread.sleep(15 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main线程结束2");
        t1.interrupt();
    }
}
