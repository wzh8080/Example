package com.example.thread.blocked;

/**
 * @Author 56465
 * @Create 2024/9/20 14:07
 */
public class Account {
    int amount = 100; // 账户初始100元
    public synchronized void deposit(int cash) { // 存钱
        amount += cash;
        System.out.println("存钱后余额：" + amount);
        notify();
        System.out.println("已通知唤醒");
        try {
            Thread.sleep(30000); // 通知后却暂时不退出
            System.out.println("等待结束");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public synchronized void withdraw(int cash) { // 取钱
        while (cash > amount) {
            try {
                System.out.println("余额不足，等待中...");
                int count = 30;
                for (int i = 0; i < count; i++) {
                    System.out.println("准备进入等待.."+(count-i));
                    Thread.sleep(1000);
                }
                wait();
                System.out.println("已唤醒");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        amount -= cash;
    }

    public void test(Object obj) throws InterruptedException {
        synchronized (obj) {
            int count = 3;
            for (int i = 0; i < count; i++) {
                System.out.println("准备wait.."+Thread.currentThread().getName()+" "+(count-i));
                Thread.sleep(1000);
            }
            wait();
            System.out.println("准备wait结束,已醒来"+Thread.currentThread().getName());
        }
    }
}
