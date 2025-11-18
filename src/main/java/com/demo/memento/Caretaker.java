package com.demo.memento;

import java.util.Stack;

/**
 * 管理者类（负责管理备忘录对象）
 */
public class Caretaker {
    // 备忘录栈：用一个栈管理备忘录，实现类似“git stash/pop 类似的思想”
    private Stack<Memento> mementos = new Stack<>();

    // 保存备忘录
    public void save(Memento memento) {
        mementos.push(memento);
    }

    // 获取备忘录
    public Memento get() {
        return mementos.pop();
    }

    // 检查是否有可恢复的状态
    public boolean hasUndo() {
        return !mementos.isEmpty();
    }
}