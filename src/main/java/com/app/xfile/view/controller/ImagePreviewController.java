package com.app.xfile.view.controller;

import com.app.xfile.function.ImageSelectionCallback;
import com.app.xfile.view.service.SelectableImageView;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ImagePreviewController {

    private VBox root;
    private StackPane imageContainer;
    private Button resetButton;
    private Button okButton;
    private SelectableImageView selectableImageView;
    private ImageSelectionCallback callback;

    public ImagePreviewController(String imagePath, ImageSelectionCallback callback) {
        this.callback = callback;
        root = new VBox(10);
        root.setAlignment(javafx.geometry.Pos.CENTER);

        imageContainer = new StackPane();
        resetButton = new Button("还原");
        resetButton.setOnAction(e -> selectableImageView.resetSelection());

        okButton = new Button("OK");
        okButton.setOnAction(e -> onClose());

        Image image = new Image("file:"+imagePath);
        selectableImageView = new SelectableImageView(image);
        imageContainer.getChildren().add(selectableImageView);

        root.getChildren().addAll(imageContainer, resetButton, okButton);
    }

    public VBox getRoot() {
        return root;
    }

    public void setImagePath(String imagePath) {
        Image image = new Image(imagePath);
        selectableImageView.setImage(image);
    }

    private void onClose() {
        // 获取选择区域的数据
        double leftWidth = selectableImageView.getLeftSelectionWidth();
        double rightWidth = selectableImageView.getRightSelectionWidth();
        double height = selectableImageView.getSelectionHeight();
        double x = selectableImageView.getSelectionX();
        double y = selectableImageView.getSelectionY();

        // 调用回调方法传递数据
        if (callback != null) {
            callback.onImageSelected(leftWidth, rightWidth, height, x, y);
        }

        // 关闭预览窗口
        ((Stage) root.getScene().getWindow()).close();
    }
}