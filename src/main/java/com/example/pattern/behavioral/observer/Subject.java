package com.example.pattern.behavioral.observer;


/**
 * // 主题接口
 * @Author 56465
 * @Create 2024/6/4 11:17
 */
public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}