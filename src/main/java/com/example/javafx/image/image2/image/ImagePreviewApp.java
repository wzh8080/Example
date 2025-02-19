package com.example.javafx.image.image2.image;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/**
 * @Author zhwang
 * @Create 2024/11/7 17:32
 */
public class ImagePreviewApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // 加载图片
        Image image = new Image("file:C:\\Users\\56465\\Pictures\\Imgs\\1.png");

        // 创建可选择的图片视图
        SelectableImageView selectableImageView = new SelectableImageView(image);

        // 创建一个堆叠布局容器
        StackPane root = new StackPane();
        root.getChildren().add(selectableImageView);

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
