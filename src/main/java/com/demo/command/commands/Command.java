package com.demo.command.commands;

/**
 * 命令接口 - 抽象命令
 * 声明执行操作的接口
 */
public interface Command {
    /**
     * 执行命令
     */
    void execute();

    /**
     * 撤销命令
     */
    void undo();
}