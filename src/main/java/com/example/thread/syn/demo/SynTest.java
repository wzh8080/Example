package com.example.thread.syn.demo;

import org.junit.Test;

/**
 * @Author 56465
 * @Create 2024/6/17 16:12
 */
public class SynTest {
    @Test
    public void test_01() throws InterruptedException {
        SynchronizedAdd adder = new SynchronizedAdd();
        Thread[] threads = new Thread[10];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    adder.add(1);
                }
            });
            threads[i].start();
        }

        // 等待所有线程完成
        for (Thread thread : threads) {
            System.out.println("累加结果：" + adder.getSum());
            thread.join();
        }
        em.out.println("最终累加结果：" + adder.getSum());
    }
}
