package com.demo.builder.builders;

import com.demo.builder.product.Car;

/**
 * 汽车建造者接口
 */
public interface CarBuilder {
    void buildWheel();
    void buildOilBox();
    void buildBody();
    Car getCar();
}