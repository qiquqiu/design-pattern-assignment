package com.demo.adapter.shapes;

import com.demo.adapter.interfaces.Shape;

public class Circle implements Shape {
    @Override
    public void Draw() {
        System.out.println("正在绘制圆形 (调用 Draw() 方法)...");
    }
}