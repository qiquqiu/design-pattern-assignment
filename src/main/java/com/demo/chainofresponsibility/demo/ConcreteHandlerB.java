package com.demo.chainofresponsibility.demo;

/**
 * 具体处理者B
 * 实现简单的责任链处理逻辑
 */
public class ConcreteHandlerB extends Handler {
    @Override
    public void handleRequest() {
        if(getSuccessor() != null) { // 如果有接替处理者
            System.out.println("处理者B放过请求，传递给下一个处理者");
            getSuccessor().handleRequest();
        } else {
            System.out.println("处理者B处理请求，无后继者！");
        }
    }
}