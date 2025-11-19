package com.demo.bridge.coffee;

import com.demo.bridge.additives.CoffeeAdditives;

/**
 * 咖啡抽象类 - 抽象部分
 * 持有实现部分的引用，建立桥接关系
 */
public abstract class Coffee {
    /**
     * 咖啡添加剂 - 桥接到实现部分
     */
    protected CoffeeAdditives additives;

    /**
     * 构造函数，注入实现部分
     * @param additives 咖啡添加剂
     */
    public Coffee(CoffeeAdditives additives) {
        this.additives = additives;
    }

    /**
     * 订购咖啡 - 抽象方法
     */
    public abstract void orderCoffee();
}