package com.demo.chainofresponsibility.demo;

/**
 * 具体处理者A
 * 实现简单的责任链处理逻辑
 */
public class ConcreteHandlerA extends Handler {
    @Override
    public void handleRequest() {
        if(getSuccessor() != null) { // 如果有接替处理者
            System.out.println("处理者A放过请求，传递给下一个处理者");
            getSuccessor().handleRequest();
        } else {
            System.out.println("处理者A处理请求，无后继者！");
        }
    }
}