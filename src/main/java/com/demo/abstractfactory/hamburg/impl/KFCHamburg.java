package com.demo.abstractfactory.hamburg.impl;

import com.demo.abstractfactory.hamburg.Hamburg;

// 肯德基汉堡
public class KFCHamburg implements Hamburg {
    @Override
    public void show() {
        System.out.println("这是一个肯德基香辣鸡腿堡！");
    }
}
