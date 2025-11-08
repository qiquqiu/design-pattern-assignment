package com.demo.abstractfactory.hamburg.impl;

import com.demo.abstractfactory.hamburg.Hamburg;

// 麦当劳汉堡
public class McDonaldsHamburg implements Hamburg {
    @Override
    public void show() {
        System.out.println("这是一个麦当劳巨无霸汉堡！");
    }
}
