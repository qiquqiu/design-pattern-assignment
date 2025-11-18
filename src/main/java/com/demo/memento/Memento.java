package com.demo.memento;

/**
 * 备忘录类（保存发起人的数据）
 */
public class Memento {
    private String data; // 数据

    public Memento(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}