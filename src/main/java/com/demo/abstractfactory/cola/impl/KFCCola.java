package com.demo.abstractfactory.cola.impl;

import com.demo.abstractfactory.cola.Cola;

// 肯德基可乐
public class KFCCola implements Cola {
    @Override
    public void show() {
        // 肯德基通常卖百事可乐，这里可以体现产品族的不同
        System.out.println("这是一杯肯德基百事可乐！");
    }
}
