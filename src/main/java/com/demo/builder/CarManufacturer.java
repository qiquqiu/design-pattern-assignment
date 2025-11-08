package com.demo.builder;

public class CarManufacturer {
    public static void main(String[] args) {
        CarDirector director = new CarDirector();

        System.out.println("--- 准备生产一辆宝马 ---");
        CarBuilder bmwBuilder = new BmwBuilder();
        Car bmwCar = director.construct(bmwBuilder);
        bmwCar.show();

        System.out.println("\n--- 准备生产一辆奔驰 ---");
        CarBuilder benzBuilder = new BenzBuilder();
        Car benzCar = director.construct(benzBuilder);
        benzCar.show();
    }
}