package com.demo.decorator.decorators;


import com.demo.decorator.components.IGoat;

public class SpeedDecorator extends GoatDecorator {
    public SpeedDecorator(IGoat goat) {
        super(goat);
    }

    @Override
    public void flee() {
        System.out.print("【奔跑速度加快！】-> ");
        super.flee();
    }
}