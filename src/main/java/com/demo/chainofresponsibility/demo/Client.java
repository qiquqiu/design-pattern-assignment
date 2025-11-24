package com.demo.chainofresponsibility.demo;

/**
 * 客户端
 * 演示最简单的责任链模式
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("=== 责任链模式演示 ===");
        System.out.println("创建责任链：处理者A -> 处理者B -> 处理者C");
        System.out.println();

        // 创建具体处理者
        Handler handler1 = new ConcreteHandlerA();
        Handler handler2 = new ConcreteHandlerB();
        Handler handler3 = new ConcreteHandlerC();

        // 设置后继处理者，形成责任链（实现聚合关系）
        handler1.setSuccessor(handler2);
        handler2.setSuccessor(handler3);

        System.out.println("从处理者A开始提交请求：");
        handler1.handleRequest();

        System.out.println("\n" + "=".repeat(50));
        System.out.println("单独测试处理者C（没有后继处理者）：");

        // 单独测试最后一个处理者
        Handler handlerC = new ConcreteHandlerC();
        handlerC.handleRequest();
    }
}