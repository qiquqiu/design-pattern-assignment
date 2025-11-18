package com.demo.state.optimize.states;

import com.demo.state.optimize.Order;

/**
 * 待支付状态 - 具体状态实现
 *
 * <p>这是订单的初始状态，表示订单已创建但用户尚未完成支付。
 * 此状态实现了 {@link OrderState} 接口，定义了在待支付状态下的所有行为。</p>
 *
 * <p><strong>状态特征：</strong></p>
 * <ul>
 *   <li>订单刚创建时的默认状态</li>
 *   <li>用户可以执行支付操作</li>
 *   <li>用户可以取消订单</li>
 *   <li>无法执行发货和确认收货操作</li>
 * </ul>
 *
 * <p><strong>状态转换规则：</strong></p>
 * <ul>
 *   <li><strong>支付成功</strong>：转换到 {@link PaidState}（已支付状态）</li>
 *   <li><strong>取消订单</strong>：转换到 {@link CancelledState}（已取消状态）</li>
 *   <li><strong>其他操作</strong>：保持当前状态不变</li>
 * </ul>
 *
 * <p><strong>业务规则：</strong></p>
 * <ul>
 *   <li>允许用户在支付前取消订单</li>
 *   <li>支付成功后订单进入下一个处理阶段</li>
 *   <li>防止在未支付的情况下进行发货操作</li>
 * </ul>
 *
 * @author 软件设计与架构课程
 * @version 1.0
 * @since 1.0
 */
public class PendingState implements OrderState {

    /**
     * 支付订单操作
     *
     * <p>在待支付状态下，用户可以完成支付操作。</p>
     *
     * <p><strong>执行流程：</strong></p>
     * <ol>
     *   <li>验证支付金额和订单信息</li>
     *   <li>执行支付处理（这里简化为直接成功）</li>
     *   <li>将订单状态转换为已支付状态</li>
     *   <li>更新订单时间戳</li>
     * </ol>
     *
     * <p><strong>状态模式优势：</strong></p>
     * <ul>
     *   <li>无需switch判断，直接实现支付逻辑</li>
     *   <li>状态转换封装在状态类中</li>
     *   <li>代码结构清晰，职责单一</li>
     * </ul>
     *
     * @param order 订单上下文对象
     * @return 支付操作是否成功
     */
    @Override
    public boolean pay(Order order) {
        System.out.println("💰 订单 " + order.getOrderId() + " 正在处理支付...");
        System.out.println("   支付金额：" + order.getAmount() + "元");

        // 执行支付逻辑（这里简化处理）
        // 在实际应用中，这里会调用支付网关接口

        // 状态转换：待支付 -> 已支付
        order.changeState(new PaidState());
        System.out.println("✅ 支付成功！订单状态变更为：已支付");

        return true;
    }

    /**
     * 发货操作
     *
     * <p>在待支付状态下，不允许执行发货操作。</p>
     *
     * <p><strong>业务规则：</strong>必须先完成支付才能发货</p>
     *
     * @param order 订单上下文对象
     * @return 发货操作是否成功（在待支付状态下始终返回false）
     */
    @Override
    public boolean ship(Order order) {
        System.out.println("❌ 发货失败：订单 " + order.getOrderId() + " 尚未支付，无法发货");
        return false;
    }

    /**
     * 确认收货操作
     *
     * <p>在待支付状态下，不允许执行确认收货操作。</p>
     *
     * @param order 订单上下文对象
     * @return 确认收货操作是否成功（在待支付状态下始终返回false）
     */
    @Override
    public boolean confirmDelivery(Order order) {
        System.out.println("❌ 确认收货失败：订单 " + order.getOrderId() + " 尚未发货，无法确认收货");
        return false;
    }

    /**
     * 取消订单操作
     *
     * <p>在待支付状态下，用户可以直接取消订单，无需额外处理。</p>
     *
     * <p><strong>执行流程：</strong></p>
     * <ol>
     *   <li>验证订单是否可取消</li>
     *   <li>执行取消操作</li>
     *   <li>将订单状态转换为已取消状态</li>
     * </ol>
     *
     * @param order 订单上下文对象
     * @return 取消操作是否成功
     */
    @Override
    public boolean cancel(Order order) {
        System.out.println("🚫 订单 " + order.getOrderId() + " 正在取消...");
        System.out.println("   订单尚未支付，可以直接取消");

        // 状态转换：待支付 -> 已取消
        order.changeState(new CancelledState());
        System.out.println("✅ 订单已成功取消");

        return true;
    }

    // ==================== 状态查询方法 ====================

    /**
     * 检查是否可以支付
     *
     * <p>待支付状态下可以执行支付操作。</p>
     *
     * @return true（可以支付）
     */
    @Override
    public boolean canPay() {
        return true;
    }

    /**
     * 检查是否可以发货
     *
     * <p>待支付状态下不能发货。</p>
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
     * <p>待支付状态下可以取消订单。</p>
     *
     * @return true（可以取消）
     */
    @Override
    public boolean canCancel() {
        return true;
    }

    // ==================== 状态信息方法 ====================

    /**
     * 获取状态名称
     *
     * @return "PENDING"
     */
    @Override
    public String getStateName() {
        return "PENDING";
    }

    /**
     * 获取状态描述
     *
     * @return "待支付"
     */
    @Override
    public String getStateDescription() {
        return "待支付";
    }

    /**
     * 获取可执行操作列表
     *
     * <p><strong>状态模式优势：</strong></p>
     * <ul>
     *   <li>每个状态类自己维护可操作列表</li>
     *   <li>状态变更时操作列表自动更新</li>
     *   <li>无需外部维护复杂的条件判断逻辑</li>
     * </ul>
     *
     * @return 可执行操作的字符串描述
     */
    @Override
    public String getAvailableActions() {
        return "可执行操作：\n" +
               "  ✅ 支付订单\n" +
               "  ✅ 取消订单\n" +
               "  ❌ 发货（需要先支付）\n" +
               "  ❌ 确认收货（需要先发货）";
    }
}