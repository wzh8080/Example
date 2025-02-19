package com.example.javafx.bar;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;

/**
 * @Author zhwang
 * @Create 2024/11/7 13:58
 */
public class Test2App extends Application {
    @Override
    public void start(Stage primaryStage) {
        // 创建一个垂直布局容器
        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(10));

        // 创建一个进度条控件
        ProgressBar progressBar = new ProgressBar(0.0); // 初始进度为 0

        // 创建一个按钮控件
        Button startButton = new Button("开始");
        startButton.setOnAction(event -> {
            // 创建一个任务来执行业务逻辑
            Task<Void> task = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    int totalFiles = 100; // 总文件数
                    Execute execute = new Execute();
                    execute.updateFiles(totalFiles, (current, total) -> {
                        Platform.runLater(() -> {
                            updateProgress(current, total);
                            updateMessage("正在更新文件 " + current);
                        });
                    });
                    return null;
                }
            };

            // 绑定进度条的进度属性到任务的进度属性
            progressBar.progressProperty().bind(task.progressProperty());

            // 启动任务
            new Thread(task).start();
        });

        // 将进度条和按钮添加到布局容器中
        vBox.getChildren().addAll(progressBar, startButton);

        // 创建场景并设置到舞台
        Scene scene = new Scene(vBox, 300, 150);
        primaryStage.setTitle("JavaFX 进度条示例");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}