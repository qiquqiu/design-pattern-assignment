package com.demo.bridge;

import com.demo.bridge.additives.*;
import com.demo.bridge.coffee.*;

/**
 * 咖啡店客户端 - 桥接模式演示
 * 展示抽象部分和实现部分的动态组合
 */
public class CoffeeShop {
    public static void main(String[] args) {
        System.out.println("欢迎光临咖啡店！\n");

        // 组合1：大杯咖啡 + 牛奶
        CoffeeAdditives milk = new Milk();
        Coffee largeMilkCoffee = new JorumCoffee(milk);
        largeMilkCoffee.orderCoffee();

        // 组合2：中杯咖啡 + 糖
        CoffeeAdditives sugar = new Sugar();
        Coffee mediumSugarCoffee = new MediumCoffee(sugar);
        mediumSugarCoffee.orderCoffee();

        // 组合3：小杯咖啡 + 柠檬
        CoffeeAdditives lemon = new Lemon();
        Coffee smallLemonCoffee = new SmallCoffee(lemon);
        smallLemonCoffee.orderCoffee();

        // 组合4：小杯咖啡 + 糖（同一种配料的不同组合）
        Coffee smallSugarCoffee = new SmallCoffee(sugar);
        smallSugarCoffee.orderCoffee();
    }
}