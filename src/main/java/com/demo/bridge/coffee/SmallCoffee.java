package com.demo.bridge.coffee;

import com.demo.bridge.additives.CoffeeAdditives;

public class SmallCoffee extends Coffee {
    public SmallCoffee(CoffeeAdditives additives) {
        super(additives);
    }

    @Override
    public void orderCoffee() {
        System.out.println("一杯小杯咖啡，" + additives.addSomething());
    }
}