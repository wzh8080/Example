package com.example.thread.blocked;


import org.junit.jupiter.api.Test;

/**
 * @Author 56465
 * @Create 2024/9/20 14:05
 */
public class BlockedTest {
    @Test
    public void testReenterBlocked() throws Exception {
        Thread.sleep(10 * 1000);
        Account account = new Account();
        Thread withdrawThread = new Thread(new Runnable() {
            public void run() {
                account.withdraw(200);
            }
        }, "取钱线程");
        System.out.println("取钱线程状态1 new：" + withdrawThread.getState());
        withdrawThread.start();
        System.out.println("取钱线程状态2 runnable：" + withdrawThread.getState());
        Thread.sleep(100); // 确保取钱线程已经得到执行
        //for (int i = 0; i < 30; i++) {
        //    System.out.println("取钱线程状态3 WAITING：" + withdrawThread.getState());
        //}

        //assertThat(withdrawThread.getState()).isEqualTo(Thread.State.WAITING);

        Thread depositThread = new Thread(new Runnable() {
            public void run() {
                account.deposit(100);
            }
        }, "存钱线程");
        //Thread.sleep(10000); // 让取钱线程等待一段时间
        System.out.println("存钱线程已启动...");
        depositThread.start();
        System.out.println("存钱线程已启动...");

        Thread.sleep(100*1000);
        System.out.println("结束");
    }
    @Test
    public void testReenterBlocked2() throws Exception {
        Thread withdrawThread = new Thread(new Runnable() {
            public void run() {
                AccountStatic.withdraw(200);
            }
        }, "取钱线程");
        System.out.println("取钱线程状态1 new：" + withdrawThread.getState());
        withdrawThread.start();
        System.out.println("取钱线程状态2 runnable：" + withdrawThread.getState());
        Thread.sleep(100); // 确保取钱线程已经得到执行
        System.out.println("取钱线程状态3 WAITING：" + withdrawThread.getState());

        //assertThat(withdrawThread.getState()).isEqualTo(Thread.State.WAITING);

        Thread depositThread = new Thread(new Runnable() {
            public void run() {
                AccountStatic.deposit(100);
            }
        }, "存钱线程");
        //Thread.sleep(10000); // 让取钱线程等待一段时间
        System.out.println("存钱线程已启动...");
        depositThread.start();
        System.out.println("存钱线程已启动...");

        Thread.sleep(100*1000);
        System.out.println("结束");
    }

    @Test
    public void testWait() throws Exception {
        Account account = new Account();
        Object obj = new Object();
        Thread testWaitThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    account.test(obj);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "等待线程1");
        Thread testWaitThread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    account.test(obj);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "等待线程2");
        testWaitThread.start();
        testWaitThread2.start();
        Thread.sleep(10 * 1000);
    }
}
