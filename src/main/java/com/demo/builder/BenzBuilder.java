package com.demo.builder;

public class BenzBuilder implements CarBuilder {
    private Car car = new Car();

    @Override
    public void buildWheel() {
        car.setWheel("奔驰的豪华车轮");
    }

    @Override
    public void buildOilBox() {
        car.setOilBox("奔驰的大容量油箱");
    }

    @Override
    public void buildBody() {
        car.setBody("奔驰的经典商务车身");
    }

    @Override
    public Car getCar() {
        return car;
    }
}