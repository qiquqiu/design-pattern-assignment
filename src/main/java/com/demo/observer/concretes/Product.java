package com.demo.observer.concretes;

import com.demo.observer.interfaces.IMember;
import com.demo.observer.interfaces.IProduct;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Product implements IProduct {
    private List<IMember> members = new ArrayList<>(); // 关注该商品的会员列表
    private String name;  // 商品名称
    private double price; // 商品价格

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void setPrice(double price) {
        // 更新价格并通知所有关注会员
        System.out.println("\n系统消息：商品 '" + this.name + "' 价格正在从 " + this.price + " 更新为 " + price);
        this.price = price;
        this.notifyObservers();
    }

    @Override
    public void attach(IMember member) {
        // 添加关注商品的会员
        if (!members.contains(member)) {
            members.add(member);
        }
    }

    @Override
    public void detach(IMember member) {
        // 移除关注商品的会员
        members.remove(member);
    }

    @Override
    public void notifyObservers() {
        // 通知所有关注该商品的会员
        for (IMember member : members) {
            member.update(this);
        }
    }
}