package com.demo.strategy.concretes;

import com.demo.strategy.interfaces.DiscountStrategy;
import lombok.Data;

/**
 * 图书实体类
 *
 * <p>这是策略模式中的上下文（Context）类，使用折扣策略来计算图书的最终价格。</p>
 *
 * <p>此类体现了策略模式的核心思想：
 * <ul>
 *   <li><strong>策略封装</strong>：将折扣算法封装在独立的策略对象中</li>
 *   <li><strong>动态切换</strong>：可以在运行时为不同的图书选择不同的折扣策略</li>
 *   <li><strong>职责分离</strong>：图书实体只负责保存基本信息，折扣计算委托给策略对象</li>
 * </ul>
 * </p>
 *
 * <p>类的设计特点：
 * <ul>
 *   <li>持有一个 DiscountStrategy 对象</li>
 *   <li>通过构造函数注入折扣策略，确保每个图书都有明确的折扣规则</li>
 *   <li>提供 getFinalPrice() 方法，将折扣计算委托给策略对象</li>
 *   <li>使用 @Data 注解自动生成 getter/setter 方法</li>
 * </ul>
 * </p>
 *
 * <p>使用示例：
 * <pre>{@code
 * // 创建策略对象
 * DiscountStrategy strategy = new ComputerBookDiscountStrategy();
 *
 * // 创建图书对象，并注入折扣策略
 * Book book = new Book("Java编程思想", 120.0, strategy);
 *
 * // 获取最终价格
 * double finalPrice = book.getFinalPrice(); // 84.0元
 * }</pre>
 * </p>
 *
 * @author 软件设计与架构课程
 * @version 1.0
 * @since 1.0
 */
@Data
public class Book {

    /**
     * 图书标题
     * <p>图书的名称，如："Java编程思想"、"新概念英语"等</p>
     */
    private String title;

    /**
     * 图书原价
     * <p>图书的原始销售价格，以元为单位，必须为正数</p>
     */
    private double originalPrice;

    /**
     * 折扣策略
     * <p>用于计算此图书折扣价格的策略对象。通过依赖注入的方式在构造时指定，
     * 这使得同一个图书类可以适用于不同的折扣策略。</p>
     */
    private DiscountStrategy discountStrategy;

    /**
     * 图书构造函数
     *
     * <p>创建一个新的图书对象，并为其指定折扣策略。</p>
     *
     * <p>通过构造函数注入策略对象，确保每个图书对象在创建时就有明确的折扣规则。</p>
     *
     * @param title 图书标题，不能为空
     * @param originalPrice 图书原价，必须为正数
     * @param strategy 折扣策略，不能为空
     * @throws IllegalArgumentException 如果标题为空或价格为负数
     */
    public Book(String title, double originalPrice, DiscountStrategy strategy) {
        this.title = title;
        this.originalPrice = originalPrice;
        this.discountStrategy = strategy;
    }

    /**
     * 获取图书的最终价格
     *
     * <p>此方法体现了策略模式的精髓：将算法的具体实现委托给策略对象。</p>
     *
     * <p>计算过程：
     * <ol>
     *   <li>获取图书的原价（originalPrice）</li>
     *   <li>调用折扣策略的 calculateDiscount() 方法</li>
     *   <li>返回折扣后的最终价格</li>
     * </ol>
     * </p>
     *
     * <p>优点：
     * <ul>
     *   <li>Book 类不需要知道具体的折扣计算逻辑</li>
     *   <li>可以在运行时动态改变折扣策略</li>
     *   <li>便于添加新的折扣类型而无需修改 Book 类</li>
     * </ul>
     * </p>
     *
     * @return 折扣后的最终价格
     * @see DiscountStrategy#calculateDiscount(double)
     */
    public double getFinalPrice() {
        return discountStrategy.calculateDiscount(this.originalPrice);
    }
}