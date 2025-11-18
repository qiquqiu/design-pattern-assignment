package com.demo.state.origin;

import lombok.Getter;

/**
 * 订单类 - 传统状态管理方式
 *
 * <p>此类展示了在没有使用状态模式时，如何使用枚举和switch语句来管理订单状态。
 * 这种方式存在以下问题：</p>
 * <ul>
 *   <li><strong>状态转换逻辑分散</strong>：每个方法中都有大量的switch判断</li>
 *   <li><strong>违反开闭原则</strong>：添加新状态需要修改所有相关方法</li>
 *   <li><strong>代码冗余</strong>：状态检查逻辑在多个方法中重复</li>
 *   <li><strong>维护困难</strong>：状态转换规则散布在各处，难以统一管理</li>
 *   <li><strong>容易出错</strong>：手动维护状态转换容易产生不一致</li>
 * </ul>
 *
 * <p><strong>对比状态模式的优势：</strong></p>
 * <ul>
 *   <li>传统方式：在一个类中管理所有状态逻辑</li>
 *   <li>状态模式：每个状态一个类，职责单一</li>
 *   <li>传统方式：使用switch/if-else判断状态</li>
 *   <li>状态模式：多态调用，无需条件判断</li>
 * </ul>
 *
 * @author 软件设计与架构课程
 * @version 1.0
 * @since 1.0
 */
@Getter
public class Order {

    /**
     * 订单状态枚举
     *
     * <p>定义了订单在其生命周期中可能经历的所有状态。
     * 这种方式虽然简单，但缺乏灵活性和扩展性。</p>
     */
    public enum OrderStatus {
        /**
         * 待支付状态
         * 订单已创建，等待用户付款
         */
        PENDING("待支付"),

        /**
         * 已支付状态
         * 用户已完成付款，等待商家发货
         */
        PAID("已支付"),

        /**
         * 已发货状态
         * 商家已发货，商品在运输途中
         */
        SHIPPED("已发货"),

        /**
         * 已完成状态
         * 用户已确认收货，订单完成
         */
        COMPLETED("已完成"),

        /**
         * 已取消状态
         * 订单被取消（可能由用户或系统触发）
         */
        CANCELLED("已取消");

        private final String description;

        OrderStatus(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 订单金额
     */
    private double amount;

    /**
     * 当前订单状态
     */
    private OrderStatus currentStatus;

    /**
     * 创建时间
     */
    private long createTime;

    /**
     * 最后更新时间
     */
    private long updateTime;

    /**
     * 构造函数
     *
     * <p>创建新订单时，初始状态为 PENDING（待支付）。</p>
     *
     * @param orderId 订单唯一标识
     * @param amount 订单金额，必须大于0
     */
    public Order(String orderId, double amount) {
        this.orderId = orderId;
        this.amount = amount;
        this.currentStatus = OrderStatus.PENDING;
        this.createTime = System.currentTimeMillis();
        this.updateTime = this.createTime;
    }

    // ==================== Getter/Setter 方法 ====================

    /**
     * 更新订单状态和时间戳
     */
    private void updateStatus(OrderStatus newStatus) {
        this.currentStatus = newStatus;
        this.updateTime = System.currentTimeMillis();
    }

    // ==================== 业务操作方法 - 展示传统方式的问题 ====================

    /**
     * 支付订单
     *
     * <p><strong>传统方式的问题：</strong></p>
     * <ul>
     *   <li>使用switch判断当前状态，代码冗长</li>
     *   <li>状态转换逻辑硬编码在方法中</li>
     *   <li>如果添加新状态，需要修改这个方法</li>
     * </ul>
     *
     * @return 操作是否成功
     */
    public boolean pay() {
        switch (currentStatus) {
            case PENDING:
                // 只有待支付状态可以进行支付操作
                updateStatus(OrderStatus.PAID);
                System.out.println("订单 " + orderId + " 支付成功，金额：" + amount + "元");
                return true;

            case PAID:
                System.out.println("订单 " + orderId + " 已经支付，请勿重复支付");
                return false;

            case SHIPPED:
                System.out.println("订单 " + orderId + " 已发货，无需支付");
                return false;

            case COMPLETED:
                System.out.println("订单 " + orderId + " 已完成，无需支付");
                return false;

            case CANCELLED:
                System.out.println("订单 " + orderId + " 已取消，无法支付");
                return false;

            default:
                System.out.println("订单 " + orderId + " 状态异常，无法支付");
                return false;
        }
    }

    /**
     * 发货操作
     *
     * <p><strong>传统方式的问题：</strong></p>
     * <ul>
     *   <li>重复的switch判断模式</li>
     *   <li>状态转换规则分散在各个方法中</li>
     *   <li>缺乏统一的状态转换管理</li>
     * </ul>
     *
     * @return 操作是否成功
     */
    public boolean ship() {
        switch (currentStatus) {
            case PENDING:
                System.out.println("订单 " + orderId + " 尚未支付，无法发货");
                return false;

            case PAID:
                // 只有已支付状态可以进行发货操作
                updateStatus(OrderStatus.SHIPPED);
                System.out.println("订单 " + orderId + " 发货成功");
                return true;

            case SHIPPED:
                System.out.println("订单 " + orderId + " 已经发货，请勿重复发货");
                return false;

            case COMPLETED:
                System.out.println("订单 " + orderId + " 已完成，无需发货");
                return false;

            case CANCELLED:
                System.out.println("订单 " + orderId + " 已取消，无法发货");
                return false;

            default:
                System.out.println("订单 " + orderId + " 状态异常，无法发货");
                return false;
        }
    }

    /**
     * 确认收货操作
     *
     * <p><strong>传统方式的问题：</strong></p>
     * <ul>
     *   <li>大量的条件分支，代码可读性差</li>
     *   <li>状态检查和转换逻辑耦合在一起</li>
     * </ul>
     *
     * @return 操作是否成功
     */
    public boolean confirmDelivery() {
        switch (currentStatus) {
            case PENDING:
                System.out.println("订单 " + orderId + " 尚未支付，无法确认收货");
                return false;

            case PAID:
                System.out.println("订单 " + orderId + " 尚未发货，无法确认收货");
                return false;

            case SHIPPED:
                // 只有已发货状态可以确认收货
                updateStatus(OrderStatus.COMPLETED);
                System.out.println("订单 " + orderId + " 确认收货，订单完成");
                return true;

            case COMPLETED:
                System.out.println("订单 " + orderId + " 已完成，请勿重复确认");
                return false;

            case CANCELLED:
                System.out.println("订单 " + orderId + " 已取消，无法确认收货");
                return false;

            default:
                System.out.println("订单 " + orderId + " 状态异常，无法确认收货");
                return false;
        }
    }

    /**
     * 取消订单操作
     *
     * <p><strong>传统方式的问题：</strong></p>
     * <ul>
     *   <li>取消逻辑需要判断多个状态</li>
     *   <li>不同状态的取消规则可能不同</li>
     * </ul>
     *
     * @return 操作是否成功
     */
    public boolean cancel() {
        switch (currentStatus) {
            case PENDING:
                // 待支付状态可以直接取消
                updateStatus(OrderStatus.CANCELLED);
                System.out.println("订单 " + orderId + " 已取消");
                return true;

            case PAID:
                // 已支付状态需要先退款再取消
                System.out.println("订单 " + orderId + " 已支付，取消需要退款处理");
                updateStatus(OrderStatus.CANCELLED);
                System.out.println("订单 " + orderId + " 退款完成，订单已取消");
                return true;

            case SHIPPED:
                System.out.println("订单 " + orderId + " 已发货，无法取消");
                return false;

            case COMPLETED:
                System.out.println("订单 " + orderId + " 已完成，无法取消");
                return false;

            case CANCELLED:
                System.out.println("订单 " + orderId + " 已经取消，请勿重复操作");
                return false;

            default:
                System.out.println("订单 " + orderId + " 状态异常，无法取消");
                return false;
        }
    }

    /**
     * 检查是否可以支付
     *
     * <p><strong>传统方式的问题：</strong></p>
     * <ul>
     *   <li>即使简单的状态检查也需要switch语句</li>
     *   <li>相同的状态检查逻辑可能在多处重复</li>
     * </ul>
     *
     * @return 是否可以支付
     */
    public boolean canPay() {
        switch (currentStatus) {
            case PENDING:
                return true;
            case PAID:
            case SHIPPED:
            case COMPLETED:
            case CANCELLED:
                return false;
            default:
                return false;
        }
    }

    /**
     * 检查是否可以发货
     *
     * @return 是否可以发货
     */
    public boolean canShip() {
        switch (currentStatus) {
            case PAID:
                return true;
            case PENDING:
            case SHIPPED:
            case COMPLETED:
            case CANCELLED:
                return false;
            default:
                return false;
        }
    }

    /**
     * 检查是否可以取消
     *
     * @return 是否可以取消
     */
    public boolean canCancel() {
        switch (currentStatus) {
            case PENDING:
            case PAID:
                return true;
            case SHIPPED:
            case COMPLETED:
            case CANCELLED:
                return false;
            default:
                return false;
        }
    }

    // ==================== 辅助方法 ====================

    /**
     * 获取当前状态描述
     *
     * @return 状态描述信息
     */
    public String getStatusDescription() {
        return currentStatus.getDescription();
    }

    /**
     * 获取订单详细信息
     *
     * @return 订单信息字符串
     */
    @Override
    public String toString() {
        return String.format("Order{id='%s', amount=%.2f, status=%s, createTime=%d}",
                           orderId, amount, currentStatus.getDescription(), createTime);
    }

    /**
     * 显示订单当前可以执行的操作
     *
     * <p><strong>传统方式的问题：</strong></p>
     * <ul>
     *   <li>需要为每个操作都调用canXxx()方法</li>
     *   <li>逻辑分散，难以集中展示</li>
     * </ul>
     */
    public void displayAvailableActions() {
        System.out.println("\n=== 订单 " + orderId + " 当前状态信息 ===");
        System.out.println("当前状态：" + currentStatus.getDescription());
        System.out.println("可执行的操作：");

        if (canPay()) {
            System.out.println("  ✓ 支付");
        }
        if (canShip()) {
            System.out.println("  ✓ 发货");
        }
        if (canCancel()) {
            System.out.println("  ✓ 取消");
        }
        if (currentStatus == OrderStatus.SHIPPED) {
            System.out.println("  ✓ 确认收货");
        }
    }
}