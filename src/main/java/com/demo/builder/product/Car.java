package com.demo.builder.product;

/**
 * 汽车-产品类（建造者模式的产品）
 */
public class Car {
    private String wheel;
    private String oilBox;
    private String body;

    public void setWheel(String wheel) {
        this.wheel = wheel;
    }

    public void setOilBox(String oilBox) {
        this.oilBox = oilBox;
    }

    public void setBody(String body) {
        this.body = body;
    }

    /**
     * 显示汽车配置信息
     */
    public void show() {
        System.out.println("汽车配置：");
        System.out.println("  车轮: " + wheel);
        System.out.println("  油箱: " + oilBox);
        System.out.println("  车身: " + body);
    }
}