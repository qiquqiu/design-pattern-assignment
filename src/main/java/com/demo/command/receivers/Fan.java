package com.demo.command.receivers;

/**
 * 风扇类 - 接收者
 */
public class Fan {
    private String location;
    private int speed; // 0: 关闭, 1: 低速, 2: 中速, 3: 高速

    public Fan(String location) {
        this.location = location;
        this.speed = 0;
    }

    /**
     * 设置高速
     */
    public void high() {
        speed = 3;
        System.out.println(location + " 风扇设置为高速");
    }

    /**
     * 设置中速
     */
    public void medium() {
        speed = 2;
        System.out.println(location + " 风扇设置为中速");
    }

    /**
     * 设置低速
     */
    public void low() {
        speed = 1;
        System.out.println(location + " 风扇设置为低速");
    }

    /**
     * 关闭风扇
     */
    public void off() {
        speed = 0;
        System.out.println(location + " 风扇已关闭");
    }

    /**
     * 获取当前速度
     */
    public int getSpeed() {
        return speed;
    }
}