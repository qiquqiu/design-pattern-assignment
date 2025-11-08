package com.demo.bridge.additives;

public class Milk implements CoffeeAdditives {
    @Override
    public String addSomething() {
        return "加牛奶";
    }
}