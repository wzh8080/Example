package com.example.pattern.behavioral.duty;

/**
 * @Author 56465
 * @Create 2024/6/6 9:31
 */
public class Client {

    public Client() {

    }

    public PurchaseRequest sendRequest(int Type, int Number, float Price) {
        return new PurchaseRequest(Type, Number, Price);
    }

}