package com.demo.abstractfactory.factory.impl;

import com.demo.abstractfactory.cola.Cola;
import com.demo.abstractfactory.cola.impl.McDonaldsCola;
import com.demo.abstractfactory.factory.FastFoodFactory;
import com.demo.abstractfactory.hamburg.Hamburg;
import com.demo.abstractfactory.hamburg.impl.McDonaldsHamburg;

// 麦当劳工厂，负责生产麦当劳产品族
public class McDonaldsFactory implements FastFoodFactory {
    @Override
    public Hamburg createHamburg() {
        return new McDonaldsHamburg();
    }

    @Override
    public Cola createCola() {
        return new McDonaldsCola();
    }
}
