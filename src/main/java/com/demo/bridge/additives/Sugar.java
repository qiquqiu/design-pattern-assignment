package com.demo.bridge.additives;

/**
 * 糖类 - 具体的咖啡添加剂实现
 */
public class Sugar implements CoffeeAdditives {
    @Override
    public String addSomething() {
        return "加糖";
    }
}