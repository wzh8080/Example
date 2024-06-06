package com.example.pattern.behavioral.observer;

/**
 * @Author 56465
 * @Create 2024/6/4 11:35
 */
public class ObserverDemo {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        Observer observer1 = new ConcreteObserver("观察者1");
        Observer observer2 = new ConcreteObserver("观察者2");

        subject.addObserver(observer1);
        subject.addObserver(observer2);

        subject.setState(10);
        subject.setState(20);

        subject.removeObserver(observer1);

        subject.setState(30);
    }
}
