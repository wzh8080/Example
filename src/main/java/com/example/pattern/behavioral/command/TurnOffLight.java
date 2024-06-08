package com.example.pattern.behavioral.command;

/**
 * @Author 56465
 * @Create 2024/6/6 10:53
 */
public class TurnOffLight implements Command {
    private Light light;
    public TurnOffLight(Light light) {
        this.light = light;
    }
    @Override
    public void execute() {
        light.Off();
    }
    @Override
    public void undo() {
        light.On();
    }

}