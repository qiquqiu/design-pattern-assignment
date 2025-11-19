package com.demo.bridge.coffee;

import com.demo.bridge.additives.CoffeeAdditives;

/**
 * 大杯咖啡 - 具体的抽象部分实现
 */
public class JorumCoffee extends Coffee {
    /**
     * 构造函数
     * @param additives 咖啡添加剂
     */
    public JorumCoffee(CoffeeAdditives additives) {
        super(additives);
    }

    @Override
    public void orderCoffee() {
        System.out.println("一杯大杯咖啡，" + additives.addSomething());
    }
}