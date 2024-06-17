package com.example.thread.syn;

import com.example.thread.ThreadUtil;

import java.util.HashMap;

/**
 * @Author 56465
 * @Create 2024/6/17 14:43
 */
public class SynHandler2 {
    public void test_01()  {
        System.out.println(ThreadUtil.getThreadName()+"进入 SynHandler2 test_01");
        synchronized (this) {
            System.out.println(ThreadUtil.getThreadName()+"进入 SynHandler2 test_01 同步代码块");
            try {
                Thread.sleep(5*1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(ThreadUtil.getThreadName()+"退出 SynHandler2 test_01 同步代码块");
        }
        System.out.println(ThreadUtil.getThreadName()+"退出 SynHandler2 test_01");
    }

    public static void test_02(){

        System.out.println(ThreadUtil.getThreadName()+"进入 SynHandler2 test_02");
        synchronized (SynHandler.class) {
            System.out.println(ThreadUtil.getThreadName()+"进入 SynHandler2 test_02 同步代码块");
            try {
                Thread.sleep(5*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(ThreadUtil.getThreadName()+"退出 SynHandler2 test_02 同步代码块");
        }
        System.out.println(ThreadUtil.getThreadName()+"退出 SynHandler2 test_02");
    }

    public synchronized void test_03()  {
        System.out.println(ThreadUtil.getThreadName()+"进入 SynHandler2 test_03 同步实例方法");
        try {
            Thread.sleep(5*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(ThreadUtil.getThreadName()+"退出 SynHandler2 test_03 同步实例方法");
    }
    public static synchronized void test_04()  {
        System.out.println(ThreadUtil.getThreadName()+"进入 SynHandler2 test_04 同步静态方法");
        try {
            Thread.sleep(5*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(ThreadUtil.getThreadName()+"退出 SynHandler2 test_04 同步静态方法");
    }


}
