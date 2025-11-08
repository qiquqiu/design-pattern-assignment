package com.demo.bridge.coffee;

import com.demo.bridge.additives.CoffeeAdditives;

public class MediumCoffee extends Coffee {
    public MediumCoffee(CoffeeAdditives additives) {
        super(additives);
    }

    @Override
    public void orderCoffee() {
        System.out.println("一杯中杯咖啡，" + additives.addSomething());
    }
}