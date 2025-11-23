package com.demo.builder.builders;

import com.demo.builder.product.Car;

/**
 * 宝马汽车建造者
 */
public class BmwBuilder implements CarBuilder {
    private Car car;

    public BmwBuilder() {
        this.car = new Car();
    }

    @Override
    public void buildWheel() {
        car.setWheel("宝马原装车轮");
    }

    @Override
    public void buildOilBox() {
        car.setOilBox("宝马原装油箱");
    }

    @Override
    public void buildBody() {
        car.setBody("宝马流线型车身");
    }

    @Override
    public Car getCar() {
        return car;
    }
}