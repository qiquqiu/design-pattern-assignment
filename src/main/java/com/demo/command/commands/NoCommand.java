package com.demo.command.commands;

/**
 * 空命令 - 具体命令
 * 用于初始化遥控器按键，避免空指针异常
 */
public class NoCommand implements Command {
    @Override
    public void execute() {
        System.out.println("该按键未设置命令");
    }

    @Override
    public void undo() {
        // 什么都不做
        System.out.println("无事发生");
    }
}