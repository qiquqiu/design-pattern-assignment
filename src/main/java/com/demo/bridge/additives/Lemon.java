package com.demo.bridge.additives;

/**
 * 柠檬类 - 具体的咖啡添加剂实现
 */
public class Lemon implements CoffeeAdditives {
    @Override
    public String addSomething() {
        return "加柠檬";
    }
}