package com.demo.strategy.strategies;

import com.demo.strategy.interfaces.DiscountStrategy;

/**
 * 计算机类图书折扣策略
 *
 * <p>这是 {@link DiscountStrategy} 接口的一个具体实现，专门用于计算机类图书的折扣计算。</p>
 *
 * <p>根据业务规则，计算机类图书享受7折优惠，即：
 * <ul>
 *   <li>折扣率：30%（相当于原价的70%）</li>
 *   <li>适用范围：所有计算机相关类别的图书</li>
 *   <li>常见书籍：Java编程、数据结构、算法、软件开发等</li>
 * </ul>
 * </p>
 *
 * <p>使用示例：
 * <pre>{@code
 * DiscountStrategy strategy = new ComputerBookDiscountStrategy();
 * double discountedPrice = strategy.calculateDiscount(100.0); // 返回 70.0
 * }</pre>
 * </p>
 *
 * @author 软件设计与架构课程
 * @version 1.0
 * @since 1.0
 */
public class ComputerBookDiscountStrategy implements DiscountStrategy {

    /**
     * 计算计算机类图书的折扣价格
     *
     * <p>此方法实现计算机类图书7折优惠的业务规则。</p>
     *
     * <p>计算公式：折扣后价格 = 原价 × 0.7</p>
     *
     * <p>例如：
     * <ul>
     *   <li>原价100元 → 折后价70元</li>
     *   <li>原价150元 → 折后价105元</li>
     *   <li>原价89.9元 → 折后价62.93元</li>
     * </ul>
     * </p>
     *
     * @param originalPrice 图书原价，必须是正数
     * @return 折扣后的价格，为原价的70%
     * @throws IllegalArgumentException 如果原始价格为负数
     */
    @Override
    public double calculateDiscount(double originalPrice) {
        System.out.println("（应用策略：计算机类图书打7折）");
        return originalPrice * 0.7;
    }
}