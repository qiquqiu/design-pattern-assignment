package com.demo.decorator.decorators;


import com.demo.decorator.components.IGoat;

public abstract class GoatDecorator implements IGoat {
    protected IGoat decoratedGoat;

    public GoatDecorator(IGoat goat) {
        this.decoratedGoat = goat;
    }

    @Override
    public void flee() {
        decoratedGoat.flee();
    }

    @Override
    public void loseLife() {
        decoratedGoat.loseLife();
    }

    @Override
    public int getLives() {
        return decoratedGoat.getLives();
    }
}