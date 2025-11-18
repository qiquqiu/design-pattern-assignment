package com.demo.state.optimize.states;

import com.demo.state.optimize.Order;

/**
 * 订单状态接口 - 状态模式的核心
 *
 * <p>这是状态模式（State Pattern）中的抽象状态（State）角色，
 * 定义了所有具体状态必须实现的公共接口。</p>
 *
 * <p><strong>状态模式核心思想：</strong></p>
 * <ul>
 *   <li>允许一个对象在其内部状态改变时改变它的行为</li>
 *   <li>对象看起来似乎修改了它的类</li>
 *   <li>将状态相关的行为局部化，并将不同状态的行为分离开来</li>
 * </ul>
 *
 * <p><strong>与传统方式对比：</strong></p>
 * <ul>
 *   <li><strong>传统方式</strong>：使用switch/if-else在一个类中管理所有状态</li>
 *   <li><strong>状态模式</strong>：每个状态一个类，通过多态调用不同行为</li>
 *   <li><strong>传统方式</strong>：状态转换逻辑分散在各个方法中</li>
 *   <li><strong>状态模式</strong>：状态转换逻辑封装在状态类中</li>
 * </ul>
 *
 * <p><strong>状态模式角色：</strong></p>
 * <ol>
 *   <li><strong>Context（上下文）</strong>：Order类，持有一个状态对象的引用</li>
 *   <li><strong>State（状态）</strong>：本接口，定义所有状态行为的接口</li>
 *   <li><strong>ConcreteState（具体状态）</strong>：各种具体状态实现类</li>
 * </ol>
 *
 * <p><strong>设计优势：</strong></p>
 * <ul>
 *   <li><strong>符合开闭原则</strong>：添加新状态无需修改现有代码</li>
 *   <li><strong>单一职责</strong>：每个状态类只负责一种状态的行为</li>
 *   <li><strong>状态封装</strong>：状态相关的行为和转换逻辑集中管理</li>
 *   <li><strong>消除条件判断</strong>：使用多态替代switch/if-else</li>
 * </ul>
 *
 * @author 软件设计与架构课程
 * @version 1.0
 * @since 1.0
 * @see com.demo.state.optimize.Order 订单上下文类
 * @see com.demo.state.optimize.states.PendingState 待支付状态实现
 * @see com.demo.state.optimize.states.PaidState 已支付状态实现
 * @see com.demo.state.optimize.states.ShippedState 已发货状态实现
 * @see com.demo.state.optimize.states.CompletedState 已完成状态实现
 * @see com.demo.state.optimize.states.CancelledState 已取消状态实现
 */
public interface OrderState {

    /**
     * 支付订单
     *
     * <p>不同状态下对支付操作的处理不同：</p>
     * <ul>
     *   <li>待支付状态：可以支付，转换到已支付状态</li>
     *   <li>其他状态：通常不允许支付操作</li>
     * </ul>
     *
     * <p><strong>与传统方式对比：</strong></p>
     * <ul>
     *   <li><strong>传统方式</strong>：在pay()方法中使用switch判断状态</li>
     *   <li><strong>状态模式</strong>：每个状态类有自己的pay()实现</li>
     * </ul>
     *
     * @param order 订单上下文对象，用于访问订单信息和状态转换
     * @return 操作是否成功
     */
    boolean pay(Order order);

    /**
     * 发货操作
     *
     * <p>不同状态下对发货操作的处理：</p>
     * <ul>
     *   <li>已支付状态：可以发货，转换到已发货状态</li>
     *   <li>其他状态：通常不允许发货操作</li>
     * </ul>
     *
     * @param order 订单上下文对象
     * @return 操作是否成功
     */
    boolean ship(Order order);

    /**
     * 确认收货操作
     *
     * <p>不同状态下对确认收货操作的处理：</p>
     * <ul>
     *   <li>已发货状态：可以确认收货，转换到已完成状态</li>
     *   <li>其他状态：通常不允许确认收货操作</li>
     * </ul>
     *
     * @param order 订单上下文对象
     * @return 操作是否成功
     */
    boolean confirmDelivery(Order order);

    /**
     * 取消订单操作
     *
     * <p>不同状态下对取消操作的处理可能不同：</p>
     * <ul>
     *   <li>待支付状态：直接取消</li>
     *   <li>已支付状态：需要退款后取消</li>
     *   <li>已发货状态：通常不允许取消</li>
     *   <li>已完成状态：不允许取消</li>
     * </ul>
     *
     * @param order 订单上下文对象
     * @return 操作是否成功
     */
    boolean cancel(Order order);

    // ==================== 状态查询方法 ====================

    /**
     * 检查当前状态是否可以支付
     *
     * <p><strong>状态模式优势：</strong></p>
     * <ul>
     *   <li>每个状态类自己决定是否可以支付</li>
     *   <li>无需外部的条件判断</li>
     *   <li>逻辑清晰，易于理解</li>
     * </ul>
     *
     * @return 当前状态是否可以执行支付操作
     */
    boolean canPay();

    /**
     * 检查当前状态是否可以发货
     *
     * @return 当前状态是否可以执行发货操作
     */
    boolean canShip();

    /**
     * 检查当前状态是否可以取消
     *
     * @return 当前状态是否可以执行取消操作
     */
    boolean canCancel();

    // ==================== 状态信息方法 ====================

    /**
     * 获取状态名称
     *
     * <p>返回当前状态的描述性名称，
     * 用于日志输出和用户界面显示。</p>
     *
     * @return 状态名称字符串
     */
    String getStateName();

    /**
     * 获取状态描述
     *
     * <p>提供更详细的状态描述信息，
     * 包括当前状态下可执行的操作等。</p>
     *
     * @return 状态描述信息
     */
    String getStateDescription();

    /**
     * 显示当前状态下的可执行操作
     *
     * <p><strong>状态模式优势：</strong></p>
     * <ul>
     *   <li>每个状态类自己管理可操作列表</li>
     *   <li>状态变更时操作列表自动更新</li>
     *   <li>无需外部维护复杂的条件判断</li>
     * </ul>
     *
     * @return 可执行操作的描述信息
     */
    String getAvailableActions();
}