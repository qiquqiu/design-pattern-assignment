package com.demo.decorator;

import com.demo.decorator.components.IGoat;
import com.demo.decorator.components.XiGoat;
import com.demo.decorator.decorators.ShieldDecorator;
import com.demo.decorator.decorators.SpeedDecorator;
import com.demo.decorator.decorators.WaterDecorator;

public class GameSimulation {
    public static void main(String[] args) {
        System.out.println("--- 游戏开始，灰太狼出现了！ ---");

        IGoat xiyangyang = new XiGoat();
        System.out.println("当前状态：");
        xiyangyang.flee();
        System.out.println("剩余生命值: " + xiyangyang.getLives());

        System.out.println("\n--- 糟糕！喜羊羊被咬了 ---");
        xiyangyang.loseLife();
        System.out.println("剩余生命值: " + xiyangyang.getLives());

        System.out.println("\n--- 喜羊羊吃到了一个红苹果！ ---");
        xiyangyang = new ShieldDecorator(xiyangyang);
        System.out.println("当前状态：");
        xiyangyang.flee();

        System.out.println("\n--- 喜羊羊又吃到了一个绿苹果！ ---");
        xiyangyang = new SpeedDecorator(xiyangyang);
        System.out.println("当前状态：");
        xiyangyang.flee();

        System.out.println("\n--- 逃到河边，喜羊羊吃了一个黄苹果！ ---");
        xiyangyang = new WaterDecorator(xiyangyang);
        System.out.println("当前状态：");
        xiyangyang.flee();

        System.out.println("\n--- 灰太狼追了上来！ ---");
        xiyangyang.loseLife();
        System.out.println("剩余生命值: " + xiyangyang.getLives());

        System.out.println("\n--- 喜羊羊成功逃脱！游戏结束 ---");
    }
}