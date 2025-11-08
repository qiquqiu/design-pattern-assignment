package com.demo.decorator.decorators;

import com.demo.decorator.components.IGoat;

public class ShieldDecorator extends GoatDecorator {
    public ShieldDecorator(IGoat goat) {
        super(goat);
    }

    @Override
    public void flee() {
        System.out.print("【开启保护罩！】-> ");
        super.flee();
    }
}