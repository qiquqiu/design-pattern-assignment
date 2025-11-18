package com.demo.strategy;

import com.demo.strategy.concretes.Book;
import com.demo.strategy.interfaces.DiscountStrategy;
import com.demo.strategy.strategies.ComputerBookDiscountStrategy;
import com.demo.strategy.strategies.EnglishBookDiscountStrategy;
import com.demo.strategy.strategies.NoDiscountStrategy;

/**
 * 图书销售系统演示类
 *
 * <p>这是策略模式（Strategy Pattern）的客户端演示程序，展示了如何在图书销售系统中
 * 使用不同的折扣策略来计算不同类型图书的最终价格。</p>
 *
 * <p>程序演示了策略模式的核心价值：
 * <ul>
 *   <li><strong>算法封装</strong>：将不同的折扣算法封装在独立的策略类中</li>
 *   <li><strong>运行时选择</strong>：可以在运行时为不同对象选择不同的策略</li>
 *   <li><strong>易于扩展</strong>：添加新的折扣类型无需修改现有代码</li>
 *   <li><strong>职责分离</strong>：将业务逻辑（折扣计算）与实体类（Book）分离</li>
 * </ul>
 * </p>
 *
 * <p>业务场景：
 * <ul>
 *   <li>计算机类图书：享受7折优惠</li>
 *   <li>英语类图书：享受6折优惠</li>
 *   <li>其他类图书（如小说）：无折扣</li>
 * </ul>
 * </p>
 *
 * <h3>程序输出示例：</h3>
 * <pre>
 * --- 顾客A购买了一本计算机图书 ---
 * （应用策略：计算机类图书打7折）
 * 图书: 《Java编程思想》 | 原价: 120.0元 | 折后价: 84.0元
 *
 * --- 顾客B购买了一本英语图书 ---
 * （应用策略：英语类图书打6折）
 * 图书: 《新概念英语》 | 原价: 90.0元 | 折后价: 54.0元
 *
 * --- 顾客C购买了一本小说 ---
 * （应用策略：此书无折扣）
 * 图书: 《三体》 | 原价: 118.0元 | 折后价: 118.0元
 * </pre>
 *
 * <p><strong>设计模式学习要点：</strong></p>
 * <ol>
 *   <li><strong>策略接口（Strategy）</strong>：DiscountStrategy 定义了所有策略的公共接口</li>
 *   <li><strong>具体策略（ConcreteStrategy）</strong>：三个策略类实现不同的折扣算法</li>
 *   <li><strong>上下文（Context）</strong>：Book 类使用策略来计算最终价格</li>
 *   <li><strong>客户端（Client）</strong>：此类负责创建策略对象并将其注入到上下文中</li>
 * </ol>
 *
 * <p><strong>与不使用策略模式的对比：</strong></p>
 * <ul>
 *   <li><strong>传统方式</strong>：Book 类中会有复杂的 if-else 或 switch 语句来判断折扣类型</li>
 *   <li><strong>策略模式</strong>：将折扣逻辑分离到独立的策略类中，代码更清晰、更易维护</li>
 * </ul>
 *
 * @author 软件设计与架构课程
 * @version 1.0
 * @since 1.0
 */
public class BookSaleSystem {

    /**
     * 程序主入口
     *
     * <p>演示策略模式在图书销售系统中的应用。通过创建不同类型的图书
     * 并为其注入相应的折扣策略，展示策略模式的实际效果。</p>
     *
     * <p>程序执行流程：
     * <ol>
     *   <li>创建三种不同的折扣策略对象</li>
     *   <li>创建三个不同类型的图书对象，并注入相应的折扣策略</li>
     *   <li>调用每个图书的 getFinalPrice() 方法计算最终价格</li>
     *   <li>输出详细的计算结果，展示不同策略的效果</li>
     * </ol>
     * </p>
     *
     * <p>重点观察：
     * <ul>
     *   <li>Book 类本身不包含任何折扣计算逻辑</li>
     *   <li>不同的图书使用不同的策略，但调用方式完全相同</li>
     *   <li>每个策略都是独立的，可以单独测试和修改</li>
     * </ul>
     * </p>
     *
     * @param args 命令行参数（本程序未使用）
     */
    public static void main(String[] args) {
        // === 策略对象准备阶段 ===
        // 预先创建好各种策略对象，在实际应用中这些可能通过工厂模式或依赖注入来管理

        /**
         * 计算机类图书折扣策略：7折优惠
         * 适用于：编程、软件工程、数据结构、算法等计算机相关图书
         */
        DiscountStrategy computerStrategy = new ComputerBookDiscountStrategy();

        /**
         * 英语类图书折扣策略：6折优惠
         * 适用于：英语教材、考试辅导、英语读物等
         */
        DiscountStrategy englishStrategy = new EnglishBookDiscountStrategy();

        /**
         * 无折扣策略：原价销售
         * 适用于：小说、文学、以及其他不参与折扣活动的图书
         */
        DiscountStrategy noDiscountStrategy = new NoDiscountStrategy();

        // === 场景演示一：计算机类图书 ===
        // 顾客购买计算机类图书，应用7折优惠策略

        System.out.println("--- 顾客A购买了一本计算机图书 ---");
        System.out.println("图书类型：计算机技术类");
        System.out.println("适用策略：7折优惠");

        // 创建图书时，为其注入计算机图书的折扣策略
        // 这里体现了策略模式的依赖注入特性
        Book computerBook = new Book("《Java编程思想》", 120.0, computerStrategy);
        double finalPriceA = computerBook.getFinalPrice();

        // 输出计算结果
        System.out.println("图书: " + computerBook.getTitle() +
                         " | 原价: 120.0元" +
                         " | 折后价: " + finalPriceA + "元");

        // === 场景演示二：英语类图书 ===
        // 顾客购买英语类图书，应用6折优惠策略

        System.out.println("\n--- 顾客B购买了一本英语图书 ---");
        System.out.println("图书类型：英语学习类");
        System.out.println("适用策略：6折优惠");

        // 创建图书时，为其注入英语图书的折扣策略
        Book englishBook = new Book("《新概念英语》", 90.0, englishStrategy);
        double finalPriceB = englishBook.getFinalPrice();

        // 输出计算结果
        System.out.println("图书: " + englishBook.getTitle() +
                         " | 原价: 90.0元" +
                         " | 折后价: " + finalPriceB + "元");

        // === 场景演示三：无折扣图书 ===
        // 顾客购买小说类图书，无折扣

        System.out.println("\n--- 顾客C购买了一本小说 ---");
        System.out.println("图书类型：小说文学类");
        System.out.println("适用策略：无折扣");

        // 创建图书时，为其注入无折扣的策略
        Book novelBook = new Book("《三体》", 118.0, noDiscountStrategy);
        double finalPriceC = novelBook.getFinalPrice();

        // 输出计算结果
        System.out.println("图书: " + novelBook.getTitle() +
                         " | 原价: 118.0元" +
                         " | 折后价: " + finalPriceC + "元");

        // === 程序总结 ===
        System.out.println("\n=== 策略模式演示完成 ===");
        System.out.println("本程序展示了策略模式如何实现：");
        System.out.println("1. 算法的封装：每种折扣策略都是独立的类");
        System.out.println("2. 运行时的选择：可以在运行时为不同对象选择策略");
        System.out.println("3. 易于扩展：添加新折扣类型无需修改现有代码");
        System.out.println("4. 职责分离：业务逻辑与实体类分离");
    }
}