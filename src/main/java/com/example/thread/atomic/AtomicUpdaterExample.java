package com.example.thread.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @Author 56465
 * @Create 2024/6/20 14:11
 */
public class AtomicUpdaterExample {
    public static void main(String[] args) {
        AtomicIntegerFieldUpdater<Person> ageUpdater =
                AtomicIntegerFieldUpdater.newUpdater(Person.class, "age");

        Person person = new Person();
        person.age = 30; // 初始化年龄

        System.out.println("Original age: " + person.age);

        // 原子地将person的age字段从30更新为31
        boolean success = ageUpdater.compareAndSet(person, 30, 31);
        if (success) {
            System.out.println("Age updated successfully.");
        } else {
            System.out.println("Update failed, value was already changed.");
        }

        System.out.println("Updated age: " + person.age);
    }
}
