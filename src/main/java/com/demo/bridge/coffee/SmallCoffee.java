package com.demo.bridge.coffee;

import com.demo.bridge.additives.CoffeeAdditives;

/**
 * 小杯咖啡 - 具体的抽象部分实现
 */
public class SmallCoffee extends Coffee {
    /**
     * 构造函数
     * @param additives 咖啡添加剂
     */
    public SmallCoffee(CoffeeAdditives additives) {
        super(additives);
    }

    @Override
    public void orderCoffee() {
        System.out.println("一杯小杯咖啡，" + additives.addSomething());
    }
}