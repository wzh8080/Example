package com.example.pattern.structural.adapter;

/**
 * 适配器类，将LegacyRectangle适配到Shape接口上
 *
 * @Author 56465
 * @Create 2024/5/20 10:18
 */
public class RectangleAdapter implements Shape {
    private LegacyRectangle legacyRectangle;

    public RectangleAdapter(LegacyRectangle legacyRectangle) {
        this.legacyRectangle = legacyRectangle;
    }

    @Override
    public void draw(int x, int y, int width, int height) {
        int x1 = x;
        int y1 = y;
        int x2 = x + width;
        int y2 = y + height;
        legacyRectangle.display(x1, y1, x2, y2);
    }
}
