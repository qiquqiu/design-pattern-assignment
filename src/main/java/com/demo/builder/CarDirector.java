package com.demo.builder;

public class CarDirector {
    public Car construct(CarBuilder builder) {
        builder.buildWheel();
        builder.buildOilBox();
        builder.buildBody();
        return builder.getCar();
    }
}