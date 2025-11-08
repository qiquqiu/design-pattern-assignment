package com.demo.adapter.adapters;

import com.demo.adapter.interfaces.Shape;
import com.demo.adapter.shapes.Angle;

public class AngleAdapter implements Shape {
    private Angle angle;

    public AngleAdapter(Angle angle) {
        this.angle = angle;
    }

    @Override
    public void Draw() {
        System.out.print("适配器工作：将 Draw() 调用转换为 -> ");
        angle.DrawAngle();
    }
}