package com.example.thread.syn.demo;

/**
 * @Author 56465
 * @Create 2024/6/17 16:12
 */
public class SynchronizedAdd {
    private int sum = 0;

    public synchronized void add(int value) {
        sum += value;
    }

    public int getSum() {
        return sum;
    }
}
