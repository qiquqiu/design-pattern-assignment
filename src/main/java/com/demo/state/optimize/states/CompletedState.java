package com.demo.state.optimize.states;

import com.demo.state.optimize.Order;

/**
 * 已完成状态 - 具体状态实现
 *
 * <p>表示用户已确认收货，订单完全完成的状态。
 * 此状态实现了 {@link OrderState} 接口，定义了在已完成状态下的所有行为。</p>
 *
 * <p><strong>状态特征：</strong></p>
 * <ul>
 *   <li>用户已确认收货，交易完成</li>
 *   <li>订单生命周期结束</li>
 *   <li>通常不允许任何状态变更操作</li>
 *   <li>可以查看订单历史和评价</li>
 * </ul>
 *
 * <p><strong>状态转换规则：</strong></p>
 * <ul>
 *   <li><strong>最终状态</strong>：已完成是订单的最终状态，不再转换到其他状态</li>
 *   <li><strong>特殊情况</strong>：可能需要特殊的售后处理（但那是售后流程，不是状态转换）</li>
 * </ul>
 *
 * <p><strong>业务规则：</strong></p>
 * <ul>
 *   <li>订单完成标志着交易成功</li>
 *   <li>触发相关后续业务（如评价、积分等）</li>
 *   <li>订单数据进入历史记录</li>
 *   <li>如需售后，走售后流程而非状态转换</li>
 * </ul>
 *
 * @author 软件设计与架构课程
 * @version 1.0
 * @since 1.0
 */
public class CompletedState implements OrderState {

    /**
     * 支付订单操作
     *
     * <p>在已完成状态下，不允许支付操作。</p>
     *
     * @param order 订单上下文对象
     * @return 支付操作是否成功（在已完成状态下始终返回false）
     */
    @Override
    public boolean pay(Order order) {
        System.out.println("❌ 支付失败：订单 " + order.getOrderId() + " 已完成，无需支付");
        return false;
    }

    /**
     * 发货操作
     *
     * <p>在已完成状态下，不允许发货操作。</p>
     *
     * @param order 订单上下文对象
     * @return 发货操作是否成功（在已完成状态下始终返回false）
     */
    @Override
    public boolean ship(Order order) {
        System.out.println("❌ 发货失败：订单 " + order.getOrderId() + " 已完成，无需发货");
        return false;
    }

    /**
     * 确认收货操作
     *
     * <p>在已完成状态下，不允许重复确认收货操作。</p>
     *
     * @param order 订单上下文对象
     * @return 确认收货操作是否成功（在已完成状态下始终返回false）
     */
    @Override
    public boolean confirmDelivery(Order order) {
        System.out.println("❌ 确认收货失败：订单 " + order.getOrderId() + " 已完成，请勿重复确认");
        return false;
    }

    /**
     * 取消订单操作
     *
     * <p>在已完成状态下，不允许取消订单操作。</p>
     *
     * <p><strong>业务规则：</strong></p>
     * <ul>
     *   <li>订单完成表示交易成功</li>
     *   <li>如有问题应通过售后流程处理</li>
     *   <li>状态转换用于订单生命周期管理，不处理售后</li>
     * </ul>
     *
     * @param order 订单上下文对象
     * @return 取消操作是否成功（在已完成状态下始终返回false）
     */
    @Override
    public boolean cancel(Order order) {
        System.out.println("❌ 取消失败：订单 " + order.getOrderId() + " 已完成，无法取消");
        System.out.println("   如有问题，请通过售后流程处理");
        return false;
    }

    // ==================== 状态查询方法 ====================

    /**
     * 检查是否可以支付
     *
     * <p>已完成状态下不能支付。</p>
     *
     * @return false（不能支付）
     */
    @Override
    public boolean canPay() {
        return false;
    }

    /**
     * 检查是否可以发货
     *
     * <p>已完成状态下不能发货。</p>
     *
     * @return false（不能发货）
     */
    @Override
    public boolean canShip() {
        return false;
    }

    /**
     * 检查是否可以取消
     *
     * <p>已完成状态下不能取消。</p>
     *
     * @return false（不能取消）
     */
    @Override
    public boolean canCancel() {
        return false;
    }

    // ==================== 状态信息方法 ====================

    /**
     * 获取状态名称
     *
     * @return "COMPLETED"
     */
    @Override
    public String getStateName() {
        return "COMPLETED";
    }

    /**
     * 获取状态描述
     *
     * @return "已完成"
     */
    @Override
    public String getStateDescription() {
        return "已完成";
    }

    /**
     * 获取可执行操作列表
     *
     * @return 可执行操作的字符串描述
     */
    @Override
    public String getAvailableActions() {
        return "可执行操作：\n" +
               "  ✅ 查看订单详情\n" +
               "  ✅ 申请售后服务\n" +
               "  ✅ 商品评价\n" +
               "  ❌ 支付订单（已完成）\n" +
               "  ❌ 发货商品（已完成）\n" +
               "  ❌ 确认收货（已完成）\n" +
               "  ❌ 取消订单（已完成）";
    }
}