package com.example.pattern.behavioral.observer;

/**
 * @Author 56465
 * @Create 2024/6/4 11:18
 */
public class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(int state) {
        System.out.println(name + " 收到更新，新状态为: " + state);
    }
}
