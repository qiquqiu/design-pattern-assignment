package com.demo.singleton;

public class SingletonMain {
    public static void main(String[] args) {
        // 获取AppConfig实例
        AppConfig config1 = AppConfig.getInstance();
        AppConfig config2 = AppConfig.getInstance();

        // 验证是否为同一个实例
        System.out.println("config1 和 config2 是否为同一实例：" + (config1 == config2));

        // 测试属性操作
        config1.setParameterA("修改后的配置参数A");
        System.out.println("config2 的 ParameterA：" + config2.getParameterA());
    }
}
