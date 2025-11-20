package com.demo.command;

import com.demo.command.commands.*;
import com.demo.command.invokers.RemoteControl;
import com.demo.command.receivers.Fan;
import com.demo.command.receivers.Light;

/**
 * 遥控器演示 - 命令模式客户端
 * 展示命令模式的实际应用：遥控器控制家电
 */
public class RemoteControlDemo {
    public static void main(String[] args) {
        System.out.println("=== 智能家居遥控器演示 ===\n");

        // 创建遥控器（调用者）
        RemoteControl remoteControl = new RemoteControl();

        // 创建家电（接收者）
        Light livingRoomLight = new Light("客厅");
        Light kitchenLight = new Light("厨房");
        Fan ceilingFan = new Fan("客厅");

        // 创建具体命令对象
        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
        LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);
        FanHighCommand fanHigh = new FanHighCommand(ceilingFan);
        FanOffCommand fanOff = new FanOffCommand(ceilingFan);

        // 配置遥控器按键：三组命令，每组一个开，一个关
        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
        remoteControl.setCommand(2, fanHigh, fanOff);

        // 显示遥控器配置
        remoteControl.display();

        System.out.println("=== 开始测试遥控器 ===\n");

        // 测试客厅灯
        System.out.println("1. 测试客厅灯：");
        remoteControl.onButtonWasPressed(0);
        remoteControl.offButtonWasPressed(0);
        System.out.println("按撤销键：");
        remoteControl.undoButtonWasPressed();

        System.out.println("\n2. 测试厨房灯：");
        remoteControl.onButtonWasPressed(1);
        remoteControl.offButtonWasPressed(1);

        System.out.println("\n3. 测试风扇：");
        remoteControl.onButtonWasPressed(2);
        System.out.println("按撤销键：");
        remoteControl.undoButtonWasPressed();

        System.out.println("\n=== 测试未设置的按键 ===");
        try {
            remoteControl.onButtonWasPressed(5);
        } catch (Exception e) {
            System.err.println("理应越界报错，只有组个命令！");
        }
    }
}