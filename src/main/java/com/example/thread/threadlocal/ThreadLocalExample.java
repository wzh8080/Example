package com.example.thread.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalExample {
    // 使用ThreadLocal为每个线程创建独立的计数器
    private static final ThreadLocal<Integer> threadLocalCounter = ThreadLocal.withInitial(() -> 0);

    // 方法用于增加当前线程的计数器并打印结果
    private static void incrementAndPrint(String threadName) {
        Integer count = threadLocalCounter.get(); // 获取当前线程的计数器
        count++; // 计数器递增
        threadLocalCounter.set(count); // 更新计数器
        System.out.println(threadName + ": 计数器值 = " + count);
    }

    // 清理当前线程的ThreadLocal资源
    private static void cleanup() {
        threadLocalCounter.remove(); // 清除当前线程的ThreadLocal变量
    }

    // 任务执行类，负责执行计数和清理操作
    static class CounterTask implements Runnable {
        private final String threadName;

        CounterTask(String name) {
            this.threadName = name;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 3; i++) {
                    incrementAndPrint(threadName);
                }
            } finally {
                // 确保无论是否发生异常，都会执行清理操作
                cleanup();
            }
        }
    }

    public static void main(String[] args) {
        // 创建固定大小的线程池
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // 提交任务到线程池，每个任务由不同的线程执行
        for (int i = 0; i < 10; i++) {
            String threadName = "Thread-" + i;
            executor.submit(new CounterTask(threadName));
        }

        // 关闭线程池，不再接受新任务
        executor.shutdown();

        // 等待所有任务完成
        try {
            executor.awaitTermination(Long.MAX_VALUE, java.util.concurrent.TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("主线程被中断");
        }

        System.out.println("所有任务执行完毕，ThreadLocal资源已清理！");
    }
}
