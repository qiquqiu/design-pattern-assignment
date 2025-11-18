package com.demo.memento;

/**
 * 发起人类（需要保存状态的对象）
 */
public class Originator {
    private String data; // 数据

    public Originator(String data) {
        this.data = data;
    }

    // 创建备忘录
    public Memento createMemento() {
        return new Memento(data);
    }

    // 恢复数据
    public void restore(Memento memento) {
        this.data = memento.getData();
    }

    // 修改数据
    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}