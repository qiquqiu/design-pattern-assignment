package com.demo.abstractfactory;

import com.demo.abstractfactory.cola.Cola;
import com.demo.abstractfactory.factory.FastFoodFactory;
import com.demo.abstractfactory.factory.impl.KFCFactory;
import com.demo.abstractfactory.factory.impl.McDonaldsFactory;
import com.demo.abstractfactory.hamburg.Hamburg;

// 客户端代码
public class FastFoodRestaurant {
    public static void main(String[] args) {
        System.out.println("--- 顾客光顾麦当劳 ---");
        // 选择麦当劳工厂
        FastFoodFactory mcDonaldsFactory = new McDonaldsFactory();
        // 从工厂获取一整套产品
        Hamburg mcHamburg = mcDonaldsFactory.createHamburg();
        Cola mcCola = mcDonaldsFactory.createCola();

        // 使用产品
        mcHamburg.show();
        mcCola.show();

        System.out.println("\n--- 顾客光顾肯德基 ---");
        // 更换为肯德基工厂
        FastFoodFactory kfcFactory = new KFCFactory();
        // 从新工厂获取另一整套产品
        Hamburg kfcHamburg = kfcFactory.createHamburg();
        Cola kfcCola = kfcFactory.createCola();

        // 使用产品
        kfcHamburg.show();
        kfcCola.show();
    }
}