package com.demo.chainofresponsibility;

import com.demo.chainofresponsibility.loggers.AbstractLogger;
import com.demo.chainofresponsibility.loggers.ConsoleLogger;
import com.demo.chainofresponsibility.loggers.ErrorLogger;
import com.demo.chainofresponsibility.loggers.FileLogger;

/**
 * 责任链模式演示类
 */
public class ChainPatternDemo {

    /**
     * 创建日志处理链：ErrorLogger → FileLogger → ConsoleLogger
     */
    private static AbstractLogger getChainOfLoggers() {
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        /*

            理论输出顺序应该是：
            Standard Console::Logger: This is an information.
            --------------------
            File::Logger: This is a debug level information.
            Standard Console::Logger: This is a debug level information.
            --------------------
            Error Console::Logger: This is an error information.
            File::Logger: This is an error information.
            Standard Console::Logger: This is an error information.

         */
        AbstractLogger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(AbstractLogger.INFO,
                "This is an information.");

        System.out.println("--------------------");

        loggerChain.logMessage(AbstractLogger.DEBUG,
                "This is a debug level information.");

        System.out.println("--------------------");

        loggerChain.logMessage(AbstractLogger.ERROR,
                "This is an error information.");
    }
}