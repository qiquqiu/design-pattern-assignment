package com.demo.state.optimize.states;

import com.demo.state.optimize.Order;

/**
 * 已取消状态 - 具体状态实现
 *
 * <p>表示订单已被取消的终态状态。
 * 此状态实现了 {@link OrderState} 接口，定义了在已取消状态下的所有行为。</p>
 *
 * <p><strong>状态特征：</strong></p>
 * <ul>
 *   <li>订单已被成功取消</li>
   <li>交易终止，订单生命周期结束</li>
   *   <li>可能涉及退款处理</li>
   *   <li>不允许任何进一步的操作</li>
 * </ul>
 *
 * <p><strong>状态转换规则：</strong></p>
 * <ul>
 *   <li><strong>最终状态</strong>：已取消是订单的最终状态之一，不再转换到其他状态</li>
 *   <li><strong>终止状态</strong>：表示订单流程的提前终止</li>
 * </ul>
 *
 * <p><strong>业务规则：</strong></p>
 * <ul>
 *   <li>订单取消表示交易终止</li>
 *   <li>根据取消阶段可能需要退款</li>
 *   <li>订单数据进入历史记录</li>
 *   <li>取消操作不可逆</li>
 * </ul>
 *
 * @author 软件设计与架构课程
 * @version 1.0
 * @since 1.0
 */
public class CancelledState implements OrderState {

    /**
     * 支付订单操作
     *
     * <p>在已取消状态下，不允许支付操作。</p>
     *
     * @param order 订单上下文对象
     * @return 支付操作是否成功（在已取消状态下始终返回false）
     */
    @Override
    public boolean pay(Order order) {
        System.out.println("❌ 支付失败：订单 " + order.getOrderId() + " 已取消，无法支付");
        return false;
    }

    /**
     * 发货操作
     *
     * <p>在已取消状态下，不允许发货操作。</p>
     *
     * @param order 订单上下文对象
     * @return 发货操作是否成功（在已取消状态下始终返回false）
     */
    @Override
    public boolean ship(Order order) {
        System.out.println("❌ 发货失败：订单 " + order.getOrderId() + " 已取消，无法发货");
        return false;
    }

    /**
     * 确认收货操作
     *
     * <p>在已取消状态下，不允许确认收货操作。</p>
     *
     * @param order 订单上下文对象
     * @return 确认收货操作是否成功（在已取消状态下始终返回false）
     */
    @Override
    public boolean confirmDelivery(Order order) {
        System.out.println("❌ 确认收货失败：订单 " + order.getOrderId() + " 已取消，无法确认收货");
        return false;
    }

    /**
     * 取消订单操作
     *
     * <p>在已取消状态下，不允许重复取消操作。</p>
     *
     * @param order 订单上下文对象
     * @return 取消操作是否成功（在已取消状态下始终返回false）
     */
    @Override
    public boolean cancel(Order order) {
        System.out.println("❌ 取消失败：订单 " + order.getOrderId() + " 已经取消，请勿重复操作");
        return false;
    }

    // ==================== 状态查询方法 ====================

    /**
     * 检查是否可以支付
     *
     * <p>已取消状态下不能支付。</p>
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
     * <p>已取消状态下不能发货。</p>
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
     * <p>已取消状态下不能重复取消。</p>
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
     * @return "CANCELLED"
     */
    @Override
    public String getStateName() {
        return "CANCELLED";
    }

    /**
     * 获取状态描述
     *
     * @return "已取消"
     */
    @Override
    public String getStateDescription() {
        return "已取消";
    }

    /**
     * 获取可执行操作列表
     *
     * @return 可执行操作的字符串描述
     */
    @Override
    public String getAvailableActions() {
        return "可执行操作：\n" +
               "  ✅ 查看取消原因\n" +
               "  ✅ 查看退款状态（如适用）\n" +
               "  ✅ 重新下单\n" +
               "  ❌ 支付订单（已取消）\n" +
               "  ❌ 发货商品（已取消）\n" +
               "  ❌ 确认收货（已取消）\n" +
               "  ❌ 取消订单（已取消）";
    }
}