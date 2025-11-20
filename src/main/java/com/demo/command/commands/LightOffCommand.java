package com.demo.command.commands;

import com.demo.command.receivers.Light;

/**
 * 关灯命令 - 具体命令
 */
public class LightOffCommand implements Command {
    private final Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }

    @Override
    public void undo() {
        light.turnOn();
    }
}