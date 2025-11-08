package com.demo.abstractfactory.cola.impl;

import com.demo.abstractfactory.cola.Cola;

// 麦当劳可乐
public class McDonaldsCola implements Cola {
    @Override
    public void show() {
        System.out.println("这是一杯麦当劳可口可乐！");
    }
}
