package com.example.javafx.bar;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.function.BiConsumer;


/**
 * @Author zhwang
 * @Create 2024/11/7 13:50
 */
public class TestApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        // 创建一个垂直布局容器
        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(10));

        // 创建一个进度条控件
        ProgressBar progressBar = new ProgressBar(0.0); // 初始进度为 0

        // 创建一个标签控件
        Label statusLabel = new Label("等待开始");

        // 创建一个按钮控件
        Button startButton = new Button("开始");
        startButton.setOnAction(event -> {
            // 创建一个任务来模拟耗时操作
            Task<Void> task = new Task<Void>() {
                @Override
                protected Void call() throws Exception {

                    executeSomething("param",(current,total)->{
                            Platform.runLater(()->{
                                updateProgress(current, total);
                                updateMessage("当前"+current);
                            });
                    });
                    //for (int i = 1; i <= 100; i++) {
                    //    if (isCancelled()) {
                    //        break;
                    //    }
                    //    updateProgress(i, 100);
                    //    updateMessage("进度: " + i + "%");
                    //    Thread.sleep(50); // 模拟耗时操作
                    //}
                    return null;
                }
            };

            // 绑定进度条的进度属性到任务的进度属性
            progressBar.progressProperty().bind(task.progressProperty());

            // 绑定标签的消息属性到任务的消息属性
            statusLabel.textProperty().bind(task.messageProperty());

            // 启动任务
            new Thread(task).start();
        });

        // 将进度条、标签和按钮添加到布局容器中
        vBox.getChildren().addAll(progressBar, statusLabel, startButton);

        // 创建场景并设置到舞台
        Scene scene = new Scene(vBox, 300, 150);
        primaryStage.setTitle("JavaFX 进度条示例");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    public void executeSomething(String p, BiConsumer<Integer,Integer> progressCallback) {
        int total =3;
        for (int i = 1; i <= total; i++) {
            try {
                Thread.sleep(1 * 1000); // 模拟耗时操作
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            progressCallback.accept(i, total);
        }
    }
}
