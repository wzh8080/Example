package com.example.thread.interrupt;

import com.example.thread.ThreadUtil;

/**
 * @Author 56465
 * @Create 2024/6/20 15:10
 */
public class InterruptExample {
    static int a = 0;

    public static void main(String[] args) throws InterruptedException {
        new InterruptExample().main();
    }
    public void main() throws InterruptedException {
        System.out.println("开始");

        //Thread workerThread = new Thread(() -> {
        //    while (!Thread.currentThread().isInterrupted()) {
        //        System.out.println(this.getClass().getName());
        //    }
        //});
        Thread workerThread = new Thread() {
            @Override
            public void run() {
                System.out.println(this.getClass().getName());
            }
        };

        workerThread.start();

        // 让主程序休眠一段时间后中断worker线程
        Thread.sleep(2000);
        workerThread.interrupt();

        workerThread.join(); // 等待worker线程结束
        System.out.println("Main thread finished.");
    }
}
