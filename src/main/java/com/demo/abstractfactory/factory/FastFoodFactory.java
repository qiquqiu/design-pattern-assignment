package com.demo.abstractfactory.factory;

import com.demo.abstractfactory.cola.Cola;
import com.demo.abstractfactory.hamburg.Hamburg;

// 快餐店抽象工厂，定义了创建一整套产品（一个产品族）的方法
public interface FastFoodFactory {
    /**
     * 生产汉堡
     * @return Hamburg 类型的汉堡
     */
    Hamburg createHamburg();

    /**
     * 生产可乐
     * @return Cola 类型的可乐
     */
    Cola createCola();
}
