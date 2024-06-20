package com.example;

import com.example.thread.ThreadUtil;
import org.junit.Test;

/**
 * 注意事项：
 *  test_01：流式写法中,this为外部对象
 * @Author 56465
 * @Create 2024/6/20 15:56
 */
public class JavaMainTest {

    /**
     * 流式写法中，this 是外部类的对象，所以 流式写法 只能在非静态方法中写this（外部类）
     * 使用流程流式写法时，获取的 this 是外部类的对象，此时所在的方法，必须时非静态的，因为 this 是外部类的对象
     * 使用匿名内部类时，获取的 this 是内部类的对象
     */
    @Test
    public void test_01(){
        Thread t1 = new Thread(() -> {
            System.out.println(ThreadUtil.getThreadName() + "  " + this.getClass().getName());
        });
        Thread t2 = new Thread() {
            @Override
            public void run() {
                System.out.println(ThreadUtil.getThreadName() + "  " + this.getClass().getName());
            }
        };
        t1.start();
        t2.start();
        System.out.println(ThreadUtil.getThreadName() + "  " + this.getClass().getName());
    }
}
