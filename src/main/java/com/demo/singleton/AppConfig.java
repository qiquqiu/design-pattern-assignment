package com.demo.singleton;

// AppConfig 类，采用单例模式实现
public class AppConfig {
    // 1. 私有静态成员变量，存储唯一实例
    private static AppConfig instance;
    // Getter 和 Setter 方法
    // 类的属性
    private String ParameterA;

    // 2. 私有化构造方法，防止外部 new
    private AppConfig() {
        // 这里可以模拟从配置文件读取参数（如ParameterA）
        this.ParameterA = "默认配置参数A";
    }

    // 3. 公共静态方法，获取唯一实例
    public static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    public String getParameterA() {
        return ParameterA;
    }

    public void setParameterA(String parameterA) {
        ParameterA = parameterA;
    }
}