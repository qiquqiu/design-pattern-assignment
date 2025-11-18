package com.demo.observer.interfaces;

import com.demo.observer.concretes.Product;

public interface IMember {
    void update(Product product);  // 接收商品价格更新通知
}