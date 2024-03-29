package com.test.record;

/**
 * @Author 56465
 * @Create 2024/3/29 11:20
 */
public record RecordDemo(String name, int age) {
    public RecordDemo(String name) {
        this(name, 0);
    }

    private static String address;

    /**
     * 此写法不规范
     */
    public RecordDemo(String name, int age, String address) {
        this(name, age);
        this.address = address;
    }

    public static String getAddress() {
        return address;
    }
}
