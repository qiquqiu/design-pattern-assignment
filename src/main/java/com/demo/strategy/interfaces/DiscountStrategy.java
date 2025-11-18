package com.demo.strategy.interfaces;

/**
 * 折扣策略接口
 *
 * <p>这是策略模式（Strategy Pattern）的核心接口，定义了所有具体折扣策略必须实现的方法。
 * 策略模式允许在运行时动态地改变算法或策略，而不影响使用策略的客户端。</p>
 *
 * <p>在图书销售系统中，不同类型的图书可能有不同的折扣策略：
 * <ul>
 *   <li>计算机类图书：7折优惠</li>
 *   <li>英语类图书：6折优惠</li>
 *   <li>其他类型图书：无折扣</li>
 * </ul>
 * </p>
 *
 * <p>通过使用策略模式，系统可以：
 * <ul>
 *   <li>轻松添加新的折扣策略，而无需修改现有代码</li>
 *   <li>在运行时为不同的图书选择不同的折扣策略</li>
 *   <li>将折扣计算逻辑与图书实体分离，提高代码的可维护性</li>
 * </ul>
 * </p>
 *
 * @see com.demo.strategy.strategies.ComputerBookDiscountStrategy 计算机图书折扣策略
 * @see com.demo.strategy.strategies.EnglishBookDiscountStrategy 英语图书折扣策略
 * @see com.demo.strategy.strategies.NoDiscountStrategy 无折扣策略
 *
 * @author 软件设计与架构课程
 * @version 1.0
 */
public interface DiscountStrategy {

    /**
     * 根据策略计算折扣后的价格
     *
     * <p>此方法是策略模式的核心，不同的具体策略类会有不同的实现。</p>
     *
     * <p>例如：
     * <ul>
     *   <li>计算机类图书：返回原价的70%</li>
     *   <li>英语类图书：返回原价的60%</li>
     *   <li>其他类型：返回原价（无折扣）</li>
     * </ul>
     * </p>
     *
     * @param originalPrice 原始价格，必须是正数
     * @return 折扣后的价格，应小于等于原价
     */
    double calculateDiscount(double originalPrice);
}