package com.test.sealed;

/**
 * @Author 56465
 * @Create 2024/3/29 16:35
 */
public sealed class SealedDemo extends CommonFather implements CommonImplement permits SealedSonFinal, SealedSonSealed, SealedSonNonSealed {

}
