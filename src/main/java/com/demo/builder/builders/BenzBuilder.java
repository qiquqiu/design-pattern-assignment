package com.demo.builder.builders;

import com.demo.builder.product.Car;

/**
 * 奔驰汽车建造者
 */
public class BenzBuilder implements CarBuilder {
    private Car car;

    public BenzBuilder() {
        this.car = new Car();
    }

    @Override
    public void buildWheel() {
        car.setWheel("奔驰豪华车轮");
    }

    @Override
    public void buildOilBox() {
        car.setOilBox("奔驰大容量油箱");
    }

    @Override
    public void buildBody() {
        car.setBody("奔驰商务车身");
    }

    @Override
    public Car getCar() {
        return car;
    }
}