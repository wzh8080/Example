package com.example.pattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 56465
 * @Create 2024/6/4 10:30
 */
public class Directory implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components;

    public Directory(String name) {
        this.name = name;
        components = new ArrayList<>();
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    public void displayInfo() {
        System.out.println("Directory: " + name);
        for (FileSystemComponent component : components) {
            component.displayInfo();
        }
    }
}