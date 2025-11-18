package com.demo.strategy.strategies;

import com.demo.strategy.interfaces.DiscountStrategy;

/**
 * 英语类图书折扣策略
 *
 * <p>这是 {@link DiscountStrategy} 接口的一个具体实现，专门用于英语类图书的折扣计算。</p>
 *
 * <p>根据业务规则，英语类图书享受6折优惠，即：
 * <ul>
 *   <li>折扣率：40%（相当于原价的60%）</li>
 *   <li>适用范围：所有英语学习相关类别的图书</li>
 *   <li>常见书籍：英语教材、英语考试辅导、英语读物等</li>
 * </ul>
 * </p>
 *
 * <p>使用示例：
 * <pre>{@code
 * DiscountStrategy strategy = new EnglishBookDiscountStrategy();
 * double discountedPrice = strategy.calculateDiscount(100.0); // 返回 60.0
 * }</pre>
 * </p>
 *
 * @author 软件设计与架构课程
 * @version 1.0
 * @since 1.0
 */
public class EnglishBookDiscountStrategy implements DiscountStrategy {

    /**
     * 计算英语类图书的折扣价格
     *
     * <p>此方法实现英语类图书6折优惠的业务规则。</p>
     *
     * <p>计算公式：折扣后价格 = 原价 × 0.6</p>
     *
     * <p>例如：
     * <ul>
     *   <li>原价100元 → 折后价60元</li>
     *   <li>原价80元 → 折后价48元</li>
     *   <li>原价59.9元 → 折后价35.94元</li>
     * </ul>
     * </p>
     *
     * @param originalPrice 图书原价，必须是正数
     * @return 折扣后的价格，为原价的60%
     * @throws IllegalArgumentException 如果原始价格为负数
     */
    @Override
    public double calculateDiscount(double originalPrice) {
        System.out.println("（应用策略：英语类图书打6折）");
        return originalPrice * 0.6;
    }
}