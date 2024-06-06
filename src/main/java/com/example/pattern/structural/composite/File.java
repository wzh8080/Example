package com.example.pattern.structural.composite;

/**
 * @Author 56465
 * @Create 2024/6/4 10:29
 */
public class File implements FileSystemComponent {
    private String name;

    public File(String name) {
        this.name = name;
    }

    public void displayInfo() {
        System.out.println("File: " + name);
    }
}