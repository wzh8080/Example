package com.example.thread.wait;

import com.example.thread.ThreadUtil;

public class TestHandler {
    public void test(){

        synchronized (this) {
            System.out.println(ThreadUtil.getThreadName() + " 进入 TestHandler test 同步块");

            try {
                System.out.println(ThreadUtil.getThreadName() + " 开始 wait");
                wait(8*1000);
//                Thread.sleep(8*1000);
//                Thread.activeCount();
                System.out.println(ThreadUtil.getThreadName() + " 结束 wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(ThreadUtil.getThreadName() + " 继续执行 sleep。。。 ");
            try {
                Thread.sleep(10 * 1000);
            } catch (InterruptedException e) {
                System.out.println(ThreadUtil.getThreadName() + " 中断 sleep");
                e.printStackTrace();
            }

            System.out.println(ThreadUtil.getThreadName() + " 出 TestHandler test 同步块");
        }
    }
}
