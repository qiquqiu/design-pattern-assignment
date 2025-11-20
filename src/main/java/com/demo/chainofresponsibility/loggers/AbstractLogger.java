package com.demo.chainofresponsibility.loggers;

import lombok.Setter;

/**
 * 责任链模式-抽象日志记录器
 */
public abstract class AbstractLogger {
    public static final int INFO = 1;
    public static final int DEBUG = 2;
    public static final int ERROR = 3;

    protected int level;

    /**
     * -- SETTER --
     *  设置责任链中下一个处理器
     */
    @Setter
    protected AbstractLogger nextLogger;

    /**
     * 处理日志消息，沿着责任链传递（核心方法）
     */
    public void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    /**
     * 具体的日志写入方法，由子类实现
     */
    protected abstract void write(String message);
}