package com.example.pattern.structural.composite;

/**
 * @Author 56465
 * @Create 2024/6/4 10:30
 */
public class CompositeDemo {
    public static void main(String[] args) {
        // 创建文件和文件夹
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");
        Directory subDirectory = new Directory("Subdirectory");
        subDirectory.addComponent(file1);
        subDirectory.addComponent(file2);

        Directory rootDirectory = new Directory("Root");
        rootDirectory.addComponent(subDirectory);

        // 展示文件系统结构
        rootDirectory.displayInfo();
    }
}