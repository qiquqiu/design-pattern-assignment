package com.demo.builder;

public class BmwBuilder implements CarBuilder {
    private Car car = new Car();

    @Override
    public void buildWheel() {
        car.setWheel("宝马的原装车轮");
    }

    @Override
    public void buildOilBox() {
        car.setOilBox("宝马的原装油箱");
    }

    @Override
    public void buildBody() {
        car.setBody("宝马的流线型车身");
    }

    @Override
    public Car getCar() {
        return car;
    }
}