package com.demo.adapter.shapes;

import com.demo.adapter.interfaces.Shape;

public class Rectangle implements Shape {
    @Override
    public void Draw() {
        System.out.println("正在绘制矩形 (调用 Draw() 方法)...");
    }
}