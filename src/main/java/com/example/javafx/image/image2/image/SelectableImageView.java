package com.example.javafx.image.image2.image;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class SelectableImageView extends Pane {

    private ImageView imageView;
    private Rectangle selectionRect;
    private Point2D dragAnchor;
    private boolean isResizing = false;
    private String resizeDirection = "";

    public SelectableImageView(Image image) {
        imageView = new ImageView(image);
        getChildren().add(imageView);

        // 创建选择框
        selectionRect = new Rectangle(0, 0, image.getWidth(), image.getHeight());
        selectionRect.setStrokeWidth(2);
        selectionRect.setFill(javafx.scene.paint.Color.TRANSPARENT);
        selectionRect.setStroke(javafx.scene.paint.Color.BLUE);
        getChildren().add(selectionRect);

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
        } else {
            setCursor(Cursor.DEFAULT);
            resizeDirection = "";
        }
    }

    private void handleMousePressed(MouseEvent event) {
        // 记录鼠标按下时的位置
        dragAnchor = new Point2D(event.getX(), event.getY());

        if (!resizeDirection.isEmpty()) {
            isResizing = true;
        }
    }

    private void handleMouseDragged(MouseEvent event) {
        if (isResizing) {
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
        }
    }

    private void handleMouseReleased(MouseEvent event) {
        isResizing = false;
        // 获取选择框的边界
        Bounds bounds = selectionRect.getBoundsInParent();

        // 打印选择框的尺寸和位置
        System.out.println("选择框位置: x=" + bounds.getMinX() + ", y=" + bounds.getMinY());
        System.out.println("选择框尺寸: width=" + bounds.getWidth() + ", height=" + bounds.getHeight());
    }

    public double getSelectionWidth() {
        return selectionRect.getWidth();
    }

    public double getSelectionHeight() {
        return selectionRect.getHeight();
    }

    public double getSelectionX() {
        return selectionRect.getX();
    }

    public double getSelectionY() {
        return selectionRect.getY();
    }
}