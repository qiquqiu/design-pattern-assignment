package com.demo.builder;

import lombok.Setter;

@Setter
public class Car {
    private String wheel;  // 车轮
    private String oilBox; // 油箱
    private String body;   // 车身

    public void show() {
        System.out.println("一辆汽车组装完毕：");
        System.out.println("  - 车轮: " + this.wheel);
        System.out.println("  - 油箱: " + this.oilBox);
        System.out.println("  - 车身: " + this.body);
    }
}