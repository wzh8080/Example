package com.example.javafx.image.image2.ok2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ImagePreviewApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // 加载图片
        Image image = new Image("file:C:/Users/56465/Pictures/Imgs/1.png");

        // 创建可选择的图片视图
        SelectableImageView selectableImageView = new SelectableImageView(image);

        // 创建一个堆叠布局容器
        StackPane imageContainer = new StackPane();
        imageContainer.getChildren().add(selectableImageView);

        // 设置图片居中
        imageContainer.setAlignment(javafx.geometry.Pos.CENTER);

        // 创建一个“还原”按钮
        Button resetButton = new Button("还原");
        resetButton.setOnAction(event -> selectableImageView.resetSelection());

        // 创建一个垂直布局容器
        VBox root = new VBox(10);
        root.getChildren().addAll(imageContainer, resetButton);

        // 创建场景并设置到舞台
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("JavaFX 图片预览工具");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}