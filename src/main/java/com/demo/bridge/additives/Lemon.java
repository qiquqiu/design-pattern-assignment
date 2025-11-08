package com.demo.bridge.additives;

public class Lemon implements CoffeeAdditives {
    @Override
    public String addSomething() {
        return "加柠檬";
    }
}