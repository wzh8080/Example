package com.example.pattern.behavioral.command;

/**
 * 请求者
 * @Author 56465
 * @Create 2024/6/6 10:53
 */
public class Control {
    public void commandExecute(Command command) {
        command.execute();
    }

    public void commandUndo(Command command) {
        command.undo();
    }
}
