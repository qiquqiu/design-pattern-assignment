package com.demo.bridge.additives;

/**
 * 牛奶类 - 具体的咖啡添加剂实现
 */
public class Milk implements CoffeeAdditives {
    @Override
    public String addSomething() {
        return "加牛奶";
    }
}