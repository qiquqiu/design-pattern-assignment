package com.demo.command.invokers;

import com.demo.command.commands.Command;
import com.demo.command.commands.NoCommand;

/**
 * 遥控器类 - 调用者
 * 持有命令对象，并请求命令执行相应的请求
 * 只与命令打交道，并且实现控制“接收者”的效果，他并不直接操作接收者，与接收者是解耦的
 */
public class RemoteControl {
    // 接受命令组，支持多组命令
    private final Command[] onCommands;
    private final Command[] offCommands;
    private Command undoCommand;

    public RemoteControl() {
        onCommands = new Command[3];
        offCommands = new Command[3];
        Command noCommand = new NoCommand();

        // 初始化所有按键为空命令
        for (int i = 0; i < 3; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    /**
     * 设置按键命令
     * @param slot 按键编号
     * @param onCommand 开命令
     * @param offCommand 关命令
     */
    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    /**
     * 按下开按钮
     */
    public void onButtonWasPressed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    /**
     * 按下关按钮
     */
    public void offButtonWasPressed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    /**
     * 按下撤销按钮
     */
    public void undoButtonWasPressed() {
        undoCommand.undo();
    }

    /**
     * 显示遥控器状态
     */
    public void display() {
        System.out.println("\n------ 遥控器 ------");
        for (int i = 0; i < 3; i++) {
            System.out.println("[slot " + i + "] " +
                onCommands[i].getClass().getSimpleName() + " / " +
                offCommands[i].getClass().getSimpleName());
        }
        System.out.println("[undo] " + undoCommand.getClass().getSimpleName());
        System.out.println("-------------------");
    }
}