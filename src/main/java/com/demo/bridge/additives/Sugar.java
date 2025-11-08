package com.demo.bridge.additives;

public class Sugar implements CoffeeAdditives {
    @Override
    public String addSomething() {
        return "加糖";
    }
}