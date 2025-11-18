package com.demo.state.optimize;

import com.demo.state.optimize.states.OrderState;
import com.demo.state.optimize.states.PendingState;
import lombok.Data;

/**
 * 订单类 - 状态模式的上下文角色
 *
 * <p>这是状态模式（State Pattern）中的上下文（Context）角色，
 * 持有一个对状态对象的引用，并将所有与状态相关的行为委托给当前状态对象。</p>
 *
 * <p><strong>状态模式核心思想：</strong></p>
 * <ul>
 *   <li>将状态相关的行为局部化到具体状态类中</li>
 *   <li>上下文类通过委托方式调用状态相关行为</li>
 *   <li>状态对象可以在运行时改变上下文的行为</li>
 * </ul>
 *
 * <p><strong>与传统方式对比：</strong></p>
 * <table border="1">
 *   <tr><th>对比项</th><th>传统方式</th><th>状态模式</th></tr>
 *   <tr><td>状态管理</td><td>一个类管理所有状态</td><td>每个状态一个类</td></tr>
 *   <tr><td>条件判断</td><td>大量switch/if-else</td><td>多态调用，无需判断</td></tr>
 *   <tr><td>职责分离</td><td>职责集中，类过大</td><td>职责单一，类小而专注</td></tr>
 *   <tr><td>扩展性</td><td>违反开闭原则</td><td>符合开闭原则</td></tr>
 *   <tr><td>可维护性</td><td>修改影响多处</td><td>修改局部化</td></tr>
 * </table>
 *
 * <p><strong>上下文类职责：</strong></p>
 * <ul>
 *   <li><strong>状态持有</strong>：维护当前状态对象的引用</li>
 *   <li><strong>行为委托</strong>：将状态相关操作委托给状态对象</li>
 *   <li><strong>状态转换</strong>：提供状态转换的方法</li>
 *   <li><strong>外部接口</strong>：为客户端提供统一的操作接口</li>
 * </ul>
 *
 * <p><strong>设计优势：</strong></p>
 * <ul>
 *   <li><strong>简化上下文</strong>：上下文类不再包含复杂的状态判断逻辑</li>
 *   <li><strong>行为封装</strong>：每个状态的行为封装在对应的状态类中</li>
 *   <li><strong>易于扩展</strong>：添加新状态只需实现OrderState接口</li>
 *   <li><strong>运行时灵活</strong>：状态可以在运行时动态改变</li>
 * </ul>
 *
 * @author 软件设计与架构课程
 * @version 1.0
 * @since 1.0
 * @see com.demo.state.optimize.states.OrderState 状态接口
 * @see com.demo.state.optimize.states.PendingState 待支付状态
 * @see com.demo.state.optimize.states.PaidState 已支付状态
 */
@Data
public class Order {

    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 订单金额
     */
    private double amount;

    /**
     * 当前订单状态对象 - 状态模式的核心
     *
     * <p>这是状态模式的关键：上下文持有状态对象的引用，
     * 而不是枚举值。通过多态调用，实现不同状态下的不同行为。</p>
     *
     * <p><strong>与传统方式对比：</strong></p>
     * <ul>
     *   <li><strong>传统方式</strong>：OrderStatus枚举 + switch判断</li>
     *   <li><strong>状态模式</strong>：OrderState对象 + 多态调用</li>
     * </ul>
     */
    private OrderState currentState;

    /**
     * 构造函数
     *
     * <p>创建新订单时，初始状态为 {@link PendingState}（待支付）。
     * 这里体现了状态模式的灵活性：上下文在创建时可以指定初始状态。</p>
     *
     * @param orderId 订单唯一标识
     * @param amount 订单金额，必须大于0
     */
    public Order(String orderId, double amount) {
        this.orderId = orderId;
        this.amount = amount;
        this.currentState = new PendingState(); // 初始状态为待支付
    }

    /**
     * 构造函数（带指定状态）
     *
     * <p>允许在创建订单时指定初始状态，
     * 提高了状态模式的灵活性。</p>
     *
     * @param orderId 订单唯一标识
     * @param amount 订单金额
     * @param initialState 初始状态
     */
    public Order(String orderId, double amount, OrderState initialState) {
        this.orderId = orderId;
        this.amount = amount;
        this.currentState = initialState;
    }

    // ==================== 状态转换方法 ====================

    /**
     * 状态转换方法
     *
     * <p>这是状态模式的核心方法，负责更改当前状态。
     * 通常由具体状态类调用，以实现状态的自动转换。</p>
     *
     * <p><strong>设计考虑：</strong></p>
     * <ul>
     *   <li>使用package-private访问级别，限制外部直接调用</li>
     *   <li>状态转换由状态类内部控制，保证转换规则的一致性</li>
     *   <li>更新时间戳，记录状态变更时间</li>
     * </ul>
     *
     * @param newState 新的状态对象
     */
    public void changeState(OrderState newState) {
        System.out.println("🔄 订单 " + orderId + " 状态变更：" +
                          this.currentState.getStateDescription() + " → " +
                          newState.getStateDescription());
        this.currentState = newState;
    }

    // ==================== 业务操作方法 - 委托给状态对象 ====================

    /**
     * 支付订单操作
     *
     * <p>将支付操作委托给当前状态对象处理。</p>
     *
     * <p><strong>状态模式优势：</strong></p>
     * <ul>
     *   <li>无需switch判断，直接委托给状态对象</li>
     *   <li>不同状态有不同的支付行为</li>
     *   <li>状态转换逻辑封装在状态类中</li>
     * </ul>
     *
     * @return 支付操作是否成功
     * @see OrderState#pay(Order)
     */
    public boolean pay() {
        return currentState.pay(this);
    }

    /**
     * 发货操作
     *
     * <p>将发货操作委托给当前状态对象处理。</p>
     *
     * @return 发货操作是否成功
     * @see OrderState#ship(Order)
     */
    public boolean ship() {
        return currentState.ship(this);
    }

    /**
     * 确认收货操作
     *
     * <p>将确认收货操作委托给当前状态对象处理。</p>
     *
     * @return 确认收货操作是否成功
     * @see OrderState#confirmDelivery(Order)
     */
    public boolean confirmDelivery() {
        return currentState.confirmDelivery(this);
    }

    /**
     * 取消订单操作
     *
     * <p>将取消操作委托给当前状态对象处理。</p>
     *
     * @return 取消操作是否成功
     * @see OrderState#cancel(Order)
     */
    public boolean cancel() {
        return currentState.cancel(this);
    }

    // ==================== 状态查询方法 - 委托给状态对象 ====================

    /**
     * 检查是否可以支付
     *
     * <p>将检查逻辑委托给当前状态对象。</p>
     *
     * @return 是否可以支付
     * @see OrderState#canPay()
     */
    public boolean canPay() {
        return currentState.canPay();
    }

    /**
     * 检查是否可以发货
     *
     * @return 是否可以发货
     * @see OrderState#canShip()
     */
    public boolean canShip() {
        return currentState.canShip();
    }

    /**
     * 检查是否可以取消
     *
     * @return 是否可以取消
     * @see OrderState#canCancel()
     */
    public boolean canCancel() {
        return currentState.canCancel();
    }

    // ==================== 状态信息方法 - 委托给状态对象 ====================

    /**
     * 获取当前状态名称
     *
     * @return 当前状态名称
     * @see OrderState#getStateName()
     */
    public String getCurrentStateName() {
        return currentState.getStateName();
    }

    /**
     * 获取当前状态描述
     *
     * @return 当前状态描述
     * @see OrderState#getStateDescription()
     */
    public String getCurrentStateDescription() {
        return currentState.getStateDescription();
    }

    // ==================== 辅助方法 ====================

    /**
     * 获取订单详细信息
     *
     * @return 订单信息字符串
     */
    @Override
    public String toString() {
        return String.format("Order{id='%s', amount=%.2f, status=%s}",
                           orderId, amount, currentState.getStateDescription());
    }

    /**
     * 显示订单当前状态和可执行操作
     *
     * <p><strong>状态模式优势：</strong></p>
     * <ul>
     *   <li>每个状态类自己管理可操作列表</li>
     *   <li>状态变更时操作列表自动更新</li>
     *   <li>无需外部维护复杂的条件判断</li>
     *   <li>信息展示逻辑也委托给状态对象</li>
     * </ul>
     */
    public void displayStatus() {
        System.out.println("\n=== 订单 " + orderId + " 当前状态信息 ===");
        System.out.println("订单金额：" + amount + "元");
        System.out.println("当前状态：" + currentState.getStateDescription());
        System.out.println("\n" + currentState.getAvailableActions());
    }

    /**
     * 获取订单的可执行操作列表
     *
     * <p>直接从当前状态对象获取可执行操作。</p>
     *
     * @return 可执行操作的描述
     * @see OrderState#getAvailableActions()
     */
    public String getAvailableActions() {
        return currentState.getAvailableActions();
    }
}