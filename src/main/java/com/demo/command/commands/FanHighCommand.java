package com.demo.command.commands;

import com.demo.command.receivers.Fan;

/**
 * 风扇高速命令 - 具体命令
 */
public class FanHighCommand implements Command {
    private final Fan fan;
    private int prevSpeed;

    public FanHighCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        prevSpeed = fan.getSpeed();
        fan.high();
    }

    @Override
    public void undo() {
        switch (prevSpeed) {
            case 3:
                fan.high();
                break;
            case 2:
                fan.medium();
                break;
            case 1:
                fan.low();
                break;
            case 0:
                fan.off();
                break;
        }
    }
}