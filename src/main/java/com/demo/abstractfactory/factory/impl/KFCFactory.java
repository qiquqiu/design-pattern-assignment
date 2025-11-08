package com.demo.abstractfactory.factory.impl;

import com.demo.abstractfactory.cola.Cola;
import com.demo.abstractfactory.cola.impl.KFCCola;
import com.demo.abstractfactory.factory.FastFoodFactory;
import com.demo.abstractfactory.hamburg.Hamburg;
import com.demo.abstractfactory.hamburg.impl.KFCHamburg;

// 肯德基工厂，负责生产肯德基产品族
public class KFCFactory implements FastFoodFactory {
    @Override
    public Hamburg createHamburg() {
        return new KFCHamburg();
    }

    @Override
    public Cola createCola() {
        return new KFCCola();
    }
}
