package com.test.sealed;

/**
 * @Author 56465
 * @Create 2024/3/29 16:35
 */
public sealed abstract class SealedDemo2 permits SealedDemo2Son{
    public abstract void abstractFunction();
}
