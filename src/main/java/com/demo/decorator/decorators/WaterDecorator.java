package com.demo.decorator.decorators;


import com.demo.decorator.components.IGoat;

public class WaterDecorator extends GoatDecorator {
    public WaterDecorator(IGoat goat) {
        super(goat);
    }

    @Override
    public void flee() {
        System.out.print("【学会了趟水跑！】-> ");
        super.flee();
    }
}