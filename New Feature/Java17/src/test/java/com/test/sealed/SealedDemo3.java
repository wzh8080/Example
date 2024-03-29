package com.test.sealed;

/**
 * @Author 56465
 * @Create 2024/3/29 17:00
 */
public sealed interface SealedDemo3 permits SealedDemo3Son{
    void interfaceFunction();
}
