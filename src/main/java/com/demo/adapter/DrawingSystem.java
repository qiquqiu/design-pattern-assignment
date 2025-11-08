package com.demo.adapter;

import com.demo.adapter.interfaces.Shape;
import com.demo.adapter.shapes.*;
import com.demo.adapter.adapters.AngleAdapter;

import java.util.ArrayList;
import java.util.List;

public class DrawingSystem {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();

        shapes.add(new Circle());
        shapes.add(new Rectangle());
        shapes.add(new Line());

        Angle legacyAngle = new Angle();
        Shape adaptedAngle = new AngleAdapter(legacyAngle);
        shapes.add(adaptedAngle);

        System.out.println("\n开始统一绘制所有图形...");
        for (Shape shape : shapes) {
            shape.Draw();
        }
    }
}