package com.demo.observer.interfaces;

public interface IProduct {
    void attach(IMember member);    // 添加关注者
    void detach(IMember member);    // 移除关注者
    void notifyObservers();         // 通知所有关注者
}