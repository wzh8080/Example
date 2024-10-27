package com.example.thread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author 56465
 * @Create 2024/9/23 16:14
 */
public class BaseTest {
    /**
     * 测试线程池的关闭
     * 强制关闭后, 会立即结束所有线程, 依然会将 finally 中的代码执行一遍
     * @throws InterruptedException
     */
    @Test
    public void shutdownTest() throws InterruptedException {
        // 创建线程池
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(() -> {
            System.out.println("已进入线程 "+Thread.currentThread().getName());
            try {
                int count = 10;
                for (int i = 0; i < count; i++) {
                    System.out.println("线程 "+Thread.currentThread().getName()+" 正在运行"+(count-i));
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("线程 "+Thread.currentThread().getName()+" 已结束");
            }
        });
        Thread.sleep(1000);
        System.out.println("开始结束");
        service.shutdown();

        Thread.sleep(3000);
        System.out.println("强制结束");
        service.shutdownNow();
    }
}
