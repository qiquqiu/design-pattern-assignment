package com.demo.command.commands;

import com.demo.command.receivers.Light;

/**
 * 开灯命令 - 具体命令
 */
public class LightOnCommand implements Command {
    private final Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }

    @Override
    public void undo() {
        light.turnOff();
    }
}