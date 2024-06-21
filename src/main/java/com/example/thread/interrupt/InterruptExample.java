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
        //    System.out.println(ThreadUtil.getThreadName()+"Thread.interrupted() = " + Thread.interrupted());
        //    System.out.println(ThreadUtil.getThreadName()+"Worker thread exiting.");
        //    System.out.println(ThreadUtil.getThreadName()+"Thread.interrupted() = " + Thread.interrupted());
        //});
        Thread workerThread = new Thread() {
            @Override
            public void run() {
                while (!this.isInterrupted()) {
                    System.out.println("睡眠开始");
                    try {
                        Thread.sleep(10*1000);
                    } catch (InterruptedException e) {
                        System.out.println(ThreadUtil.getThreadName()+"this.isInterrupted() = " + this.isInterrupted());
                        System.out.println("中断了，catch ing");;
                        this.interrupt();
                        System.out.println(ThreadUtil.getThreadName()+"this.isInterrupted() = " + this.isInterrupted());
                    }
                    System.out.println("睡眠结束");
                    System.out.println(ThreadUtil.getThreadName()+"this.isInterrupted() = " + this.isInterrupted());

                }
                System.out.println(ThreadUtil.getThreadName()+"this.isInterrupted() = " + this.isInterrupted());
                System.out.println(ThreadUtil.getThreadName()+"Worker thread exiting.");
            }
        };


        workerThread.start();

        // 让主程序休眠一段时间后中断worker线程
        Thread.sleep(2000);
        System.out.println("主线程："+ThreadUtil.getThreadName()+"workerThread.isInterrupted() = " + workerThread.isInterrupted());
        workerThread.interrupt();
        System.out.println("主线程："+"结束");
        System.out.println("主线程："+ThreadUtil.getThreadName()+"workerThread.isInterrupted() = " + workerThread.isInterrupted());

        // 异步的，所以worker线程可能还没有结束，中断了任务，被catch住，其线程的状态不是 interrupt，需要在catch中主动调用interrupt


        workerThread.join(); // 等待worker线程结束
        System.out.println("主线程："+"Main thread finished.");
    }
}
