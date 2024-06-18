package com.example.thread.join;

import com.example.thread.ThreadUtil;

public class TestRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(ThreadUtil.getThreadName() + "线程执行中...");
        for (int i = 0; i < 10; i++) {
            System.out.println(ThreadUtil.getThreadName() + "循环开始：" + i);
            test();
            try {
                Thread.sleep(5*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(ThreadUtil.getThreadName() + "循环结束：" + i);
        }
    }

    public void test(){
        synchronized (this) {
            System.out.println(ThreadUtil.getThreadName() + "进入同步块");
            try {
                Thread.sleep(5 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(ThreadUtil.getThreadName() + "出同步块");
        }
    }
}
