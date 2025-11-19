package com.demo.bridge.coffee;

import com.demo.bridge.additives.CoffeeAdditives;

/**
 * 中杯咖啡 - 具体的抽象部分实现
 */
public class MediumCoffee extends Coffee {
    /**
     * 构造函数
     * @param additives 咖啡添加剂
     */
    public MediumCoffee(CoffeeAdditives additives) {
        super(additives);
    }

    @Override
    public void orderCoffee() {
        System.out.println("一杯中杯咖啡，" + additives.addSomething());
    }
}