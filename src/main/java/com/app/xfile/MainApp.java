package com.app.xfile;

import com.app.xfile.view.controller.FileSelectionController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        FileSelectionController fileSelectionController = new FileSelectionController(primaryStage);
        Scene scene = new Scene(fileSelectionController.getRoot(), 600, 400);
        primaryStage.setTitle("图片选择工具");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}