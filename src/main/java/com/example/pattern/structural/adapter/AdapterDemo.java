package com.example.pattern.structural.adapter;

/**
 * 适配器模式（Adapter）
 * 在这个示例中，LegacyRectangle是已经存在的类，而RectangleAdapter是适配器类，用于将LegacyRectangle适配到Shape接口上。
 * 客户端代码通过使用适配器来画一个矩形，实际上是在调用了LegacyRectangle的display方法，但是通过适配器，它符合了Shape接口的标准。
 *
 * @Author 56465
 * @Create 2024/5/20 10:20
 */
public class AdapterDemo {
    public static void main(String[] args) {
        LegacyRectangle legacyRectangle = new LegacyRectangle();
        Shape shapeAdapter = new RectangleAdapter(legacyRectangle);

        shapeAdapter.draw(10, 20, 50, 30);
    }
}
