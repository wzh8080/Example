package com.example.thread.atomic;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicIntegerTest {
    int b = 0;
    @Test
    public void test_01(){
        AtomicInteger a = new AtomicInteger(0);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                a.incrementAndGet();
                b++;
            }

        });
        t1.start();

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                a.incrementAndGet();
                b++;
            }
        });
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        AtomicIntegerArray array = new AtomicIntegerArray(10);

        System.out.println("a="+a);
        System.out.println("b="+b);
    }
    
    @Test
    public void test_02(){
        AtomicInteger a = new AtomicInteger(3);
        int i = a.incrementAndGet();
        System.out.println("i = " + i + " a = " + a);
        int i1 = a.getAndAdd(2);
        System.out.println("i1 = " + i1 + " a = " + a);

        int b = 0;
        b++;
        System.out.println("b = " + b);
    }
}
