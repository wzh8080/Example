package com.example.thread.wait;

public class Demo2 {
    public static void main(String[] args) {
        System.out.println("当前线程数："+Thread.activeCount());
        Thread.getAllStackTraces().keySet().forEach(System.out::println);
        System.out.println("---------");
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        while (group != null) {
            System.out.println(group.getName());
            group = group.getParent();
        }

    }
}
