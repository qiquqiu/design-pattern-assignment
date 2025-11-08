package com.demo.bridge.coffee;

import com.demo.bridge.additives.CoffeeAdditives;

public abstract class Coffee {
    protected CoffeeAdditives additives;

    public Coffee(CoffeeAdditives additives) {
        this.additives = additives;
    }

    public abstract void orderCoffee();
}