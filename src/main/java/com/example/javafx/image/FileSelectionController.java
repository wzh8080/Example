package com.example.javafx.image;

import com.example.javafx.image.ImageSelectionCallback;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class FileSelectionController implements ImageSelectionCallback {

    private VBox root;
    private TextField filePathField;
    private Button selectFileButton;
    private Button previewButton;
    private Button executeButton;
    private Stage primaryStage;

    public FileSelectionController(Stage primaryStage) {
        this.primaryStage = primaryStage;
        root = new VBox(10);
        root.setAlignment(javafx.geometry.Pos.CENTER);

        filePathField = new TextField();
        filePathField.setPrefWidth(400);

        selectFileButton = new Button("选择图片");
        selectFileButton.setOnAction(e -> onSelectFile());

        previewButton = new Button("预览");
        previewButton.setOnAction(e -> onPreview());

        executeButton = new Button("执行");
        executeButton.setOnAction(e -> onExecute());

        root.getChildren().addAll(filePathField, selectFileButton, previewButton, executeButton);
    }

    public VBox getRoot() {
        return root;
    }

    private void onSelectFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        File selectedFile = fileChooser.showOpenDialog(primaryStage);
        if (selectedFile != null) {
            filePathField.setText(selectedFile.getAbsolutePath());
        }
    }

    private void onPreview() {
        String imagePath = filePathField.getText();
        if (imagePath == null || imagePath.isEmpty()) {
            return;
        }

        ImagePreviewController imagePreviewController = new ImagePreviewController(imagePath, this);
        Stage previewStage = new Stage();
        previewStage.setTitle("图片预览");
        previewStage.setScene(new Scene(imagePreviewController.getRoot(), 800, 600));
        previewStage.show();
    }

    private void onExecute() {
        // 在这里处理传回的数据
        // 例如，打印数据
        System.out.println("执行操作");
    }

    @Override
    public void onImageSelected(double leftWidth, double rightWidth, double height, double x, double y) {
        // 处理传回的数据
        System.out.println("左半部分宽度: " + leftWidth);
        System.out.println("右半部分宽度: " + rightWidth);
        System.out.println("高度: " + height);
        System.out.println("X坐标: " + x);
        System.out.println("Y坐标: " + y);
    }
}