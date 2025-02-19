package com.example.javafx.image;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class SelectableImageView extends Pane {

    private ImageView imageView;
    private Rectangle selectionRect;
    private Line dividerLine;
    private Point2D dragAnchor;
    private boolean isResizing = false;
    private boolean isDraggingDivider = false;
    private String resizeDirection = "";
    private double initialX, initialY, initialWidth, initialHeight, dividerX, boundX, boundY;

    public SelectableImageView(Image image) {
        imageView = new ImageView(image);
        getChildren().add(imageView);

        // 创建选择框
        selectionRect = new Rectangle(0, 0, image.getWidth(), image.getHeight());
        selectionRect.setStrokeWidth(2);
        selectionRect.setFill(javafx.scene.paint.Color.TRANSPARENT);
        selectionRect.setStroke(javafx.scene.paint.Color.BLUE);
        getChildren().add(selectionRect);

        // 创建分割线
        dividerLine = new Line(0, 0, 0, image.getHeight());
        dividerLine.setStrokeWidth(2);
        dividerLine.setStroke(javafx.scene.paint.Color.RED);
        getChildren().add(dividerLine);

        // 记录初始位置和大小
        initialX = selectionRect.getX();
        initialY = selectionRect.getY();
        initialWidth = selectionRect.getWidth();
        initialHeight = selectionRect.getHeight();
        dividerX = selectionRect.getWidth() / 2;

        // 设置分割线的初始位置
        updateDividerLine();

        // 添加鼠标事件监听器
        setOnMouseMoved(this::handleMouseMoved);
        setOnMousePressed(this::handleMousePressed);
        setOnMouseDragged(this::handleMouseDragged);
        setOnMouseReleased(this::handleMouseReleased);
    }

    private void handleMouseMoved(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();
        Bounds bounds = selectionRect.getBoundsInLocal();

        // 检查鼠标是否在选择框的边缘
        if (x > bounds.getMinX() - 5 && x < bounds.getMinX() + 5) {
            if (y > bounds.getMinY() - 5 && y < bounds.getMinY() + 5) {
                setCursor(Cursor.NW_RESIZE);
                resizeDirection = "NW";
            } else if (y > bounds.getMaxY() - 5 && y < bounds.getMaxY() + 5) {
                setCursor(Cursor.SW_RESIZE);
                resizeDirection = "SW";
            } else {
                setCursor(Cursor.W_RESIZE);
                resizeDirection = "W";
            }
        } else if (x > bounds.getMaxX() - 5 && x < bounds.getMaxX() + 5) {
            if (y > bounds.getMinY() - 5 && y < bounds.getMinY() + 5) {
                setCursor(Cursor.NE_RESIZE);
                resizeDirection = "NE";
            } else if (y > bounds.getMaxY() - 5 && y < bounds.getMaxY() + 5) {
                setCursor(Cursor.SE_RESIZE);
                resizeDirection = "SE";
            } else {
                setCursor(Cursor.E_RESIZE);
                resizeDirection = "E";
            }
        } else if (y > bounds.getMinY() - 5 && y < bounds.getMinY() + 5) {
            setCursor(Cursor.N_RESIZE);
            resizeDirection = "N";
        } else if (y > bounds.getMaxY() - 5 && y < bounds.getMaxY() + 5) {
            setCursor(Cursor.S_RESIZE);
            resizeDirection = "S";
        } else if (Math.abs(x - dividerX) < 5) {
            setCursor(Cursor.H_RESIZE);
            resizeDirection = "H";
        } else {
            setCursor(Cursor.DEFAULT);
            resizeDirection = "";
        }
    }

    private void handleMousePressed(MouseEvent event) {
        // 记录鼠标按下时的位置
        dragAnchor = new Point2D(event.getX(), event.getY());

        if (resizeDirection.equals("H")) {
            isDraggingDivider = true;
        } else if (!resizeDirection.isEmpty()) {
            isResizing = true;
        }
    }

    private void handleMouseDragged(MouseEvent event) {
        if (isDraggingDivider) {
            double newX = event.getX();
            dividerX = Math.max(selectionRect.getX(), Math.min(newX, selectionRect.getX() + selectionRect.getWidth()));
            updateDividerLine();
        } else if (isResizing) {
            double newX = event.getX();
            double newY = event.getY();

            switch (resizeDirection) {
                case "NW":
                    selectionRect.setWidth(selectionRect.getWidth() - (newX - dragAnchor.getX()));
                    selectionRect.setHeight(selectionRect.getHeight() - (newY - dragAnchor.getY()));
                    selectionRect.setX(selectionRect.getX() + (newX - dragAnchor.getX()));
                    selectionRect.setY(selectionRect.getY() + (newY - dragAnchor.getY()));
                    break;
                case "NE":
                    selectionRect.setWidth(selectionRect.getWidth() + (newX - dragAnchor.getX()));
                    selectionRect.setHeight(selectionRect.getHeight() - (newY - dragAnchor.getY()));
                    selectionRect.setY(selectionRect.getY() + (newY - dragAnchor.getY()));
                    break;
                case "SW":
                    selectionRect.setWidth(selectionRect.getWidth() - (newX - dragAnchor.getX()));
                    selectionRect.setHeight(selectionRect.getHeight() + (newY - dragAnchor.getY()));
                    selectionRect.setX(selectionRect.getX() + (newX - dragAnchor.getX()));
                    break;
                case "SE":
                    selectionRect.setWidth(selectionRect.getWidth() + (newX - dragAnchor.getX()));
                    selectionRect.setHeight(selectionRect.getHeight() + (newY - dragAnchor.getY()));
                    break;
                case "W":
                    selectionRect.setWidth(selectionRect.getWidth() - (newX - dragAnchor.getX()));
                    selectionRect.setX(selectionRect.getX() + (newX - dragAnchor.getX()));
                    break;
                case "E":
                    selectionRect.setWidth(selectionRect.getWidth() + (newX - dragAnchor.getX()));
                    break;
                case "N":
                    selectionRect.setHeight(selectionRect.getHeight() - (newY - dragAnchor.getY()));
                    selectionRect.setY(selectionRect.getY() + (newY - dragAnchor.getY()));
                    break;
                case "S":
                    selectionRect.setHeight(selectionRect.getHeight() + (newY - dragAnchor.getY()));
                    break;
            }

            // 保持分割线在选择框内
            dividerX = Math.max(selectionRect.getX(), Math.min(dividerX, selectionRect.getX() + selectionRect.getWidth()));
            updateDividerLine();
            dragAnchor = new Point2D(event.getX(), event.getY());
        } else {
            // 计算鼠标移动的距离
            double deltaX = event.getX() - dragAnchor.getX();
            double deltaY = event.getY() - dragAnchor.getY();

            // 更新选择框的位置
            selectionRect.setX(selectionRect.getX() + deltaX);
            selectionRect.setY(selectionRect.getY() + deltaY);

            // 更新拖动锚点
            dragAnchor = new Point2D(event.getX(), event.getY());
            updateDividerLine();
        }
    }

    private void handleMouseReleased(MouseEvent event) {
        isResizing = false;
        isDraggingDivider = false;
        // 获取选择框的边界
        Bounds bounds = selectionRect.getBoundsInParent();

        boundX = bounds.getWidth();
        boundY = bounds.getHeight();
        // 打印选择框的尺寸和位置
        System.out.println("选择框位置: x=" + bounds.getMinX() + ", y=" + bounds.getMinY());
        System.out.println("选择框尺寸: width=" + boundX + ", height=" + boundY);
        System.out.println("左半部分尺寸: width=" + (dividerX - selectionRect.getX()) + ", height=" + boundY);
        System.out.println("右半部分尺寸: width=" + (boundX - (dividerX - selectionRect.getX())) + ", height=" + boundY);
    }

    private void updateDividerLine() {
        dividerLine.setStartX(dividerX);
        dividerLine.setEndX(dividerX);
        dividerLine.setStartY(selectionRect.getY());
        dividerLine.setEndY(selectionRect.getY() + selectionRect.getHeight());
    }

    public void resetSelection() {
        selectionRect.setX(initialX);
        selectionRect.setY(initialY);
        selectionRect.setWidth(initialWidth);
        selectionRect.setHeight(initialHeight);
        dividerX = initialWidth / 2;
        updateDividerLine();
    }

    public void setImage(Image image) {
        imageView.setImage(image);
        selectionRect.setWidth(image.getWidth());
        selectionRect.setHeight(image.getHeight());
        dividerX = image.getWidth() / 2;
        updateDividerLine();
    }

    public double getLeftSelectionWidth() {
        return dividerX - selectionRect.getX();
    }

    public double getRightSelectionWidth() {
        return boundX - (dividerX - selectionRect.getX());
    }

    public double getSelectionHeight() {
        return boundY;
    }

    public double getSelectionX() {
        return selectionRect.getX();
    }

    public double getSelectionY() {
        return selectionRect.getY();
    }
}