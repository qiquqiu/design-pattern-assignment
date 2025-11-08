package com.demo.bridge;

import com.demo.bridge.additives.*;
import com.demo.bridge.coffee.*;

public class CoffeeShop {
    public static void main(String[] args) {
        System.out.println("欢迎光临咖啡店！");

        CoffeeAdditives milk = new Milk();
        Coffee largeMilkCoffee = new JorumCoffee(milk);
        largeMilkCoffee.orderCoffee();

        CoffeeAdditives sugar = new Sugar();
        Coffee mediumSugarCoffee = new MediumCoffee(sugar);
        mediumSugarCoffee.orderCoffee();

        CoffeeAdditives lemon = new Lemon();
        Coffee smallLemonCoffee = new SmallCoffee(lemon);
        smallLemonCoffee.orderCoffee();

        Coffee smallSugarCoffee = new SmallCoffee(sugar);
        smallSugarCoffee.orderCoffee();
    }
}