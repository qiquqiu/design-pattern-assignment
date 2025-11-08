package com.demo.decorator.components;

public class XiGoat implements IGoat {
    private int lives = 5;

    @Override
    public void flee() {
        System.out.println("喜羊羊正在拼命逃跑！");
    }

    @Override
    public void loseLife() {
        if (this.lives > 0) {
            this.lives--;
            System.out.println("被灰太狼咬到了，喜羊羊少了一条命！");
        } else {
            System.out.println("喜羊羊已经没有命了...");
        }
    }

    @Override
    public int getLives() {
        return this.lives;
    }
}