package com.example.pattern.behavioral.command;

/**
 * @Author 56465
 * @Create 2024/6/6 10:52
 */
public interface Command {
    public void execute();
    public void undo();
}
