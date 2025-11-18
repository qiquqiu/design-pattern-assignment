package com.demo.state.optimize;

/**
 * 状态模式演示类
 *
 * <p>此类展示了状态模式在订单管理系统中的应用，
 * 通过对比传统方式，突出状态模式的优势和优雅性。</p>
 *
 * <p><strong>演示内容：</strong></p>
 * <ul>
 *   <li>状态模式的核心概念和角色</li>
 *   <li>订单状态的生命周期管理</li>
 *   <li>状态模式与传统方式的对比</li>
 *   <li>状态模式的设计优势和实际应用</li>
 * </ul>
 *
 * <p><strong>观察重点：</strong></p>
 * <ol>
 *   <li>Order类如何通过委托调用状态行为</li>
 *   <li>状态转换的自动性和一致性</li>
 *   <li>代码结构的清晰性和可维护性</li>
 *   <li>扩展新状态的简易性</li>
 * </ol>
 *
 * <p><strong>状态模式学习要点：</strong></p>
 * <ul>
 *   <li><strong>对象行为随状态改变</strong>：同一操作在不同状态下有不同表现</li>
 *   <li><strong>状态转换封装</strong>：转换规则封装在状态类中</li>
 *   <li><strong>多态替代条件判断</strong>：用虚方法调用替代switch语句</li>
 *   <li><strong>符合设计原则</strong>：开闭原则、单一职责原则</li>
 * </ul>
 *
 * @author 软件设计与架构课程
 * @version 1.0
 * @since 1.0
 */
public class OrderDemo {

    /**
     * 主程序入口
     *
     * <p>演示状态模式的完整应用场景，包括正常流程、异常处理和设计优势分析。</p>
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        System.out.println("=== 状态模式演示 ===");
        System.out.println("此演示展示了如何使用状态模式优雅地管理订单状态");

        // === 场景一：正常的订单流程 ===
        demonstrateNormalOrderFlow();

        // === 场景二：订单取消流程 ===
        demonstrateOrderCancelFlow();

        // === 场景三：异常操作演示 ===
        demonstrateInvalidOperations();

        // === 场景四：状态模式优势分析 ===
        demonstrateStatePatternAdvantages();

        // === 场景五：与传统方式对比 ===
        demonstrateComparisonWithTraditionalApproach();
    }

    /**
     * 演示正常的订单处理流程
     *
     * <p>展示状态模式下订单从创建到完成的完整生命周期：
     * 创建 → 待支付 → 支付 → 发货 → 确认收货 → 完成</p>
     *
     * <p><strong>状态模式特点：</strong></p>
     * <ul>
     *   <li>每个操作都委托给当前状态对象</li>
     *   <li>状态转换自动且一致</li>
     *   <li>代码简洁，无复杂条件判断</li>
     * </ul>
     */
    private static void demonstrateNormalOrderFlow() {
        System.out.println("\n\n📦 场景一：正常订单流程演示");
        System.out.println("=====================================");

        // 创建订单 - 初始状态为PendingState
        Order order = new Order("ORD-S001", 299.99);
        System.out.println("✅ 创建订单：" + order);
        order.displayStatus();

        // 步骤1：支付订单 - 委托给PendingState处理
        System.out.println("\n💰 步骤1：支付订单");
        boolean payResult = order.pay();
        System.out.println("支付结果：" + (payResult ? "成功" : "失败"));
        System.out.println("当前状态：" + order.getCurrentStateDescription());
        order.displayStatus();

        // 步骤2：发货 - 委托给PaidState处理
        System.out.println("\n🚚 步骤2：发货");
        boolean shipResult = order.ship();
        System.out.println("发货结果：" + (shipResult ? "成功" : "失败"));
        System.out.println("当前状态：" + order.getCurrentStateDescription());
        order.displayStatus();

        // 步骤3：确认收货 - 委托给ShippedState处理
        System.out.println("\n✅ 步骤3：确认收货");
        boolean confirmResult = order.confirmDelivery();
        System.out.println("确认结果：" + (confirmResult ? "成功" : "失败"));
        System.out.println("当前状态：" + order.getCurrentStateDescription());
        order.displayStatus();
    }

    /**
     * 演示订单取消流程
     *
     * <p>展示不同状态下取消操作的处理方式，
     * 体现状态模式在处理异常情况时的灵活性。</p>
     */
    private static void demonstrateOrderCancelFlow() {
        System.out.println("\n\n🚫 场景二：订单取消流程演示");
        System.out.println("=====================================");

        // 子场景2.1：待支付状态取消
        System.out.println("\n2.1 待支付状态取消：");
        Order pendingOrder = new Order("ORD-S002", 199.99);
        System.out.println("创建订单：" + pendingOrder);
        pendingOrder.displayStatus();

        boolean cancelPending = pendingOrder.cancel();
        System.out.println("取消结果：" + (cancelPending ? "成功" : "失败"));
        System.out.println("当前状态：" + pendingOrder.getCurrentStateDescription());
        pendingOrder.displayStatus();

        // 子场景2.2：已支付状态取消
        System.out.println("\n2.2 已支付状态取消：");
        Order paidOrder = new Order("ORD-S003", 399.99);
        System.out.println("创建订单：" + paidOrder);

        // 先支付
        paidOrder.pay();
        System.out.println("当前状态：" + paidOrder.getCurrentStateDescription());

        // 再取消
        boolean cancelPaid = paidOrder.cancel();
        System.out.println("取消结果：" + (cancelPaid ? "成功" : "失败"));
        System.out.println("当前状态：" + paidOrder.getCurrentStateDescription());
        paidOrder.displayStatus();
    }

    /**
     * 演示各种异常或无效操作
     *
     * <p>展示状态模式如何优雅地处理在错误状态下执行操作的情况。</p>
     */
    private static void demonstrateInvalidOperations() {
        System.out.println("\n\n⚠️ 场景三：异常操作演示");
        System.out.println("=====================================");

        // 创建已完成的订单
        Order completedOrder = new Order("ORD-S004", 159.99);
        // 快速完成订单
        completedOrder.pay();
        completedOrder.ship();
        completedOrder.confirmDelivery();

        System.out.println("\n3.1 对已完成订单的操作：");
        System.out.println("订单状态：" + completedOrder.getCurrentStateDescription());
        completedOrder.displayStatus();

        // 尝试各种操作 - 都会委托给CompletedState处理
        boolean payAgain = completedOrder.pay();
        System.out.println("重复支付结果：" + (payAgain ? "成功" : "失败"));

        boolean shipAgain = completedOrder.ship();
        System.out.println("发货结果：" + (shipAgain ? "成功" : "失败"));

        boolean cancelCompleted = completedOrder.cancel();
        System.out.println("取消结果：" + (cancelCompleted ? "成功" : "失败"));
    }

    /**
     * 演示状态模式的优势
     *
     * <p>通过代码分析和实际效果展示状态模式的 设计优势。</p>
     */
    private static void demonstrateStatePatternAdvantages() {
        System.out.println("\n\n🎯 场景四：状态模式优势分析");
        System.out.println("=====================================");

        Order order = new Order("ORD-S005", 259.99);
        System.out.println("📋 状态模式优势分析：");
        System.out.println();

        System.out.println("1️⃣ 消除条件判断：");
        System.out.println("   - 订单类中的pay()方法只是简单的委托调用");
        System.out.println("   - 无需switch/if-else判断当前状态");
        System.out.println("   - 代码简洁清晰，易于理解");
        System.out.println();

        System.out.println("2️⃣ 状态行为封装：");
        System.out.println("   - 每个状态的行为封装在独立的状态类中");
        System.out.println("   - 状态相关的逻辑集中管理");
        System.out.println("   - 降低了上下文类的复杂度");
        System.out.println();

        System.out.println("3️⃣ 符合开闭原则：");
        System.out.println("   - 添加新状态只需实现OrderState接口");
        System.out.println("   - 无需修改现有代码");
        System.out.println("   - 扩展性强，维护成本低");
        System.out.println();

        System.out.println("4️⃣ 单一职责原则：");
        System.out.println("   - Order类：负责订单基本信息和委托");
        System.out.println("   - State类：负责特定状态的行为逻辑");
        System.out.println("   - 职责分离，类的设计更加清晰");
        System.out.println();

        System.out.println("5️⃣ 状态转换一致性：");
        System.out.println("   - 状态转换逻辑封装在状态类中");
        System.out.println("   - 转换规则集中管理，不易出错");
        System.out.println("   - 保证了状态转换的正确性");
    }

    /**
     * 演示状态模式与传统方式的对比
     *
     * <p>通过具体代码对比，展示状态模式的改进效果。</p>
     */
    private static void demonstrateComparisonWithTraditionalApproach() {
        System.out.println("\n\n📊 场景五：与传统方式对比");
        System.out.println("=====================================");

        System.out.println("🔄 代码结构对比：");
        System.out.println();

        System.out.println("传统方式（switch语句）：");
        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│ Order类（包含所有状态逻辑）     │");
        System.out.println("│ ┌─────────────────────────────┐ │");
        System.out.println("│ │ pay()方法包含5个case分支     │ │");
        System.out.println("│ │ ship()方法包含5个case分支    │ │");
        System.out.println("│ │ cancel()方法包含5个case分支  │ │");
        System.out.println("│ │ ...                         │ │");
        System.out.println("│ └─────────────────────────────┘ │");
        System.out.println("└─────────────────────────────────┘");
        System.out.println();

        System.out.println("状态模式（多态调用）：");
        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│ Order类（上下文角色）           │");
        System.out.println("│ ┌─────────────────────────────┐ │");
        System.out.println("│ │ pay() → state.pay(this)      │ │");
        System.out.println("│ │ ship() → state.ship(this)    │ │");
        System.out.println("│ │ cancel() → state.cancel(this)│ │");
        System.out.println("│ └─────────────────────────────┘ │");
        System.out.println("└─────────────────────────────────┘");
        System.out.println("         ↓ 委托给状态对象");
        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│ PendingState, PaidState, ...   │");
        System.out.println("│ （每个状态一个独立的类）       │");
        System.out.println("└─────────────────────────────────┘");
        System.out.println();

        System.out.println("🎯 关键差异：");
        System.out.println("• 条件判断 vs 多态调用");
        System.out.println("• 单一类庞大 vs 多个小类");
        System.out.println("• 违反开闭原则 vs 符合开闭原则");
        System.out.println("• 状态逻辑分散 vs 状态逻辑集中");
        System.out.println("• 扩展困难 vs 扩展容易");
        System.out.println();

        System.out.println("💡 学习总结：");
        System.out.println("状态模式通过将状态相关行为封装到独立的状态类中，");
        System.out.println("使用多态替代条件判断，实现了代码的简化、");
        System.out.println("职责的分离和系统的可扩展性。");
    }
}