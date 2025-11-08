package com.demo.bridge.coffee;

import com.demo.bridge.additives.CoffeeAdditives;

public class JorumCoffee extends Coffee {
    public JorumCoffee(CoffeeAdditives additives) {
        super(additives);
    }

    @Override
    public void orderCoffee() {
        System.out.println("一杯大杯咖啡，" + additives.addSomething());
    }
}