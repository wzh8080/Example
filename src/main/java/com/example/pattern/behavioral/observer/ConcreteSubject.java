package com.example.pattern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;
/**
 * @Author 56465
 * @Create 2024/6/4 11:17
 */
public class ConcreteSubject implements Subject {
    // 观察者列表
    private List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }
}
