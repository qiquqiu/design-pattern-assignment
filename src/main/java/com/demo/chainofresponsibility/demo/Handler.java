package com.demo.chainofresponsibility.demo;

import lombok.Data;

/**
 * 抽象处理者
 * 责任链模式的核心抽象类，定义了处理请求的接口和后继处理者
 */
@Data
public abstract class Handler {
    private Handler successor;  // 后继处理者（自聚合）

    /**
     * 处理请求的抽象方法，由具体处理者实现
     */
    public abstract void handleRequest();
}