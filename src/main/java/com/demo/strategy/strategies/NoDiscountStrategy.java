package com.demo.strategy.strategies;

import com.demo.strategy.interfaces.DiscountStrategy;

/**
 * 无折扣策略
 *
 * <p>这是 {@link DiscountStrategy} 接口的一个具体实现，用于不需要折扣或不符合折扣条件的图书。</p>
 *
 * <p>此策略适用于：
 * <ul>
 *   <li>小说、文学类图书</li>
 *   <li>不参与折扣活动的图书</li>
 *   <li>已经是特价或清仓的图书</li>
 *   <li>其他未在折扣范围内的图书类别</li>
 * </ul>
 * </p>
 *
 * <p>该策略确保了策略模式的完整性，所有图书都能找到适用的折扣策略，
 * 避免了空指针异常，同时保持了系统的一致性。</p>
 *
 * <p>使用示例：
 * <pre>{@code
 * DiscountStrategy strategy = new NoDiscountStrategy();
 * double finalPrice = strategy.calculateDiscount(100.0); // 返回 100.0
 * }</pre>
 * </p>
 *
 * @author 软件设计与架构课程
 * @version 1.0
 * @since 1.0
 */
public class NoDiscountStrategy implements DiscountStrategy {

    /**
     * 计算无折扣图书的价格
     *
     * <p>此方法实现无折扣的业务规则，直接返回原价。</p>
     *
     * <p>计算公式：折扣后价格 = 原价（无变化）</p>
     *
     * <p>特点：
     * <ul>
     *   <li>不进行任何价格调整</li>
     *   <li>保持原价不变</li>
     *   <li>确保所有图书都有适用的策略</li>
     * </ul>
     * </p>
     *
     * @param originalPrice 图书原价，必须是正数
     * @return 与原价相同的价格
     * @throws IllegalArgumentException 如果原始价格为负数
     */
    @Override
    public double calculateDiscount(double originalPrice) {
        System.out.println("（应用策略：此书无折扣）");
        return originalPrice;
    }
}