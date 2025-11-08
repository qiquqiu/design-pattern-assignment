package com.demo.builder;

public interface CarBuilder {
    void buildWheel();
    void buildOilBox();
    void buildBody();
    Car getCar();
}