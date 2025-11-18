package com.demo.memento;

/**
 * 备忘录模式演示
 */
public class MementoDemo {
    public static void main(String[] args) {
        // 创建发起人
        Originator originator = new Originator("数据1");

        // 创建管理者
        Caretaker caretaker = new Caretaker();

        System.out.println("初始数据: " + originator.getData());

        // 保存当前数据
        System.out.println("\n保存数据...");
        caretaker.save(originator.createMemento());

        // 修改数据
        originator.setData("数据2");
        System.out.println("修改后数据: " + originator.getData());

        // 再次保存数据
        System.out.println("\n再次保存数据...");
        caretaker.save(originator.createMemento());

        // 继续修改数据
        originator.setData("数据3");
        System.out.println("再次修改后数据: " + originator.getData());

        // 恢复到上一个数据
        System.out.println("\n撤销操作...");
        if (caretaker.hasUndo()) {
            originator.restore(caretaker.get());
            System.out.println("恢复后数据: " + originator.getData());
        }

        // 再次撤销
        System.out.println("\n再次撤销...");
        if (caretaker.hasUndo()) {
            originator.restore(caretaker.get());
            System.out.println("再次恢复后数据: " + originator.getData());
        }

        // 检查是否还能撤销
        System.out.println("\n检查撤销功能...");
        if (caretaker.hasUndo()) {
            System.out.println("还可以撤销");
        } else {
            System.out.println("没有可撤销的数据了");
        }
    }
}