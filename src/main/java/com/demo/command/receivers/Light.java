package com.demo.command.receivers;

/**
 * 电灯类 - 接收者
 * 知道如何实施与执行一个请求相关的操作
 */
public class Light {
    private String location;

    public Light(String location) {
        this.location = location;
    }

    /**
     * 开灯
     */
    public void turnOn() {
        System.out.println(location + " 灯已打开");
    }

    /**
     * 关灯
     */
    public void turnOff() {
        System.out.println(location + " 灯已关闭");
    }
}