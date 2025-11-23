package com.demo.builder.demo;

import com.demo.builder.builders.BmwBuilder;
import com.demo.builder.builders.BenzBuilder;
import com.demo.builder.director.CarDirector;
import com.demo.builder.product.Car;

/**
 * 汽车制造演示类
 */
public class CarManufacturer {
    public static void main(String[] args) {
        CarDirector director = new CarDirector();

        System.out.println("=== 生产宝马 ===");
        Car bmwCar = director.construct(new BmwBuilder());
        bmwCar.show();

        System.out.println("\n=== 生产奔驰 ===");
        Car benzCar = director.construct(new BenzBuilder());
        benzCar.show();
    }
}