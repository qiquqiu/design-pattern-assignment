package com.demo.builder.director;

import com.demo.builder.builders.CarBuilder;
import com.demo.builder.product.Car;

/**
 * 汽车建造指导者
 */
public class CarDirector {
    /**
     * 按固定顺序建造汽车
     */
    public Car construct(CarBuilder builder) {
        builder.buildWheel();
        builder.buildOilBox();
        builder.buildBody();
        return builder.getCar();
    }
}