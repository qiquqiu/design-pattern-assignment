package com.demo.state.origin;

/**
 * 传统状态管理方式演示类
 *
 * <p>此类展示了使用传统switch方式管理订单状态的完整流程，
 * 以及这种方式在实际使用中遇到的问题和不便之处。</p>
 *
 * <p><strong>演示内容：</strong></p>
 * <ul>
 *   <li>创建订单和管理状态转换</li>
 *   <li>展示传统方式的工作流程</li>
 *   <li>暴露传统方式的问题</li>
 *   <li>为状态模式的学习做铺垫</li>
 * </ul>
 *
 * <p><strong>观察重点：</strong></p>
 * <ol>
 *   <li>每个操作方法中都有大量的switch判断</li>
 *   <li>状态转换逻辑分散在各个方法中</li>
 *   <li>代码重复度高，维护困难</li>
 *   <li>添加新状态需要修改多处代码</li>
 * </ol>
 *
 * @author 软件设计与架构课程
 * @version 1.0
 * @since 1.0
 */
public class OrderDemo {

    /**
     * 主程序入口
     *
     * <p>演示传统状态管理方式的完整订单生命周期，
     * 包括正常流程和异常情况的处理。</p>
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        System.out.println("=== 传统状态管理方式演示 ===");
        System.out.println("此演示展示了使用switch语句管理订单状态的传统方式及其问题");

        // === 场景一：正常的订单流程 ===
        demonstrateNormalOrderFlow();

        // === 场景二：订单取消流程 ===
        demonstrateOrderCancelFlow();

        // === 场景三：异常操作演示 ===
        demonstrateInvalidOperations();

        // === 场景四：展示传统方式的问题 ===
        demonstrateProblems();
    }

    /**
     * 演示正常的订单处理流程
     *
     * <p>展示一个订单从创建到完成的完整生命周期：
     * 创建 → 待支付 → 支付 → 发货 → 确认收货 → 完成</p>
     */
    private static void demonstrateNormalOrderFlow() {
        System.out.println("\n\n📦 场景一：正常订单流程演示");
        System.out.println("=====================================");

        // 创建订单
        Order order = new Order("ORD001", 299.99);
        System.out.println("✅ 创建订单：" + order);

        // 显示初始状态和可执行操作
        order.displayAvailableActions();

        // 步骤1：支付订单
        System.out.println("\n💰 步骤1：支付订单");
        boolean payResult = order.pay();
        System.out.println("支付结果：" + (payResult ? "成功" : "失败"));
        System.out.println("当前状态：" + order.getStatusDescription());
        order.displayAvailableActions();

        // 步骤2：发货
        System.out.println("\n🚚 步骤2：发货");
        boolean shipResult = order.ship();
        System.out.println("发货结果：" + (shipResult ? "成功" : "失败"));
        System.out.println("当前状态：" + order.getStatusDescription());
        order.displayAvailableActions();

        // 步骤3：确认收货
        System.out.println("\n✅ 步骤3：确认收货");
        boolean confirmResult = order.confirmDelivery();
        System.out.println("确认结果：" + (confirmResult ? "成功" : "失败"));
        System.out.println("当前状态：" + order.getStatusDescription());
        order.displayAvailableActions();
    }

    /**
     * 演示订单取消流程
     *
     * <p>展示订单在不同阶段的取消操作：
     * 待支付状态取消和已支付状态取消</p>
     */
    private static void demonstrateOrderCancelFlow() {
        System.out.println("\n\n🚫 场景二：订单取消流程演示");
        System.out.println("=====================================");

        // 子场景2.1：待支付状态取消
        System.out.println("\n2.1 待支付状态取消：");
        Order pendingOrder = new Order("ORD002", 199.99);
        System.out.println("创建订单：" + pendingOrder);
        pendingOrder.displayAvailableActions();

        boolean cancelPending = pendingOrder.cancel();
        System.out.println("取消结果：" + (cancelPending ? "成功" : "失败"));
        System.out.println("当前状态：" + pendingOrder.getStatusDescription());
        pendingOrder.displayAvailableActions();

        // 子场景2.2：已支付状态取消
        System.out.println("\n2.2 已支付状态取消：");
        Order paidOrder = new Order("ORD003", 399.99);
        System.out.println("创建订单：" + paidOrder);

        // 先支付
        paidOrder.pay();
        System.out.println("当前状态：" + paidOrder.getStatusDescription());

        // 再取消
        boolean cancelPaid = paidOrder.cancel();
        System.out.println("取消结果：" + (cancelPaid ? "成功" : "失败"));
        System.out.println("当前状态：" + paidOrder.getStatusDescription());
        paidOrder.displayAvailableActions();
    }

    /**
     * 演示各种异常或无效操作
     *
     * <p>展示在错误状态下执行操作的处理结果，
     * 体现状态检查的必要性。</p>
     */
    private static void demonstrateInvalidOperations() {
        System.out.println("\n\n⚠️ 场景三：异常操作演示");
        System.out.println("=====================================");

        // 创建已完成的订单
        Order completedOrder = new Order("ORD004", 159.99);
        // 快速完成订单
        completedOrder.pay();
        completedOrder.ship();
        completedOrder.confirmDelivery();

        System.out.println("\n3.1 对已完成订单的操作：");
        System.out.println("订单状态：" + completedOrder.getStatusDescription());

        // 尝试重复支付
        boolean payAgain = completedOrder.pay();
        System.out.println("重复支付结果：" + (payAgain ? "成功" : "失败"));

        // 尝试发货
        boolean shipAgain = completedOrder.ship();
        System.out.println("发货结果：" + (shipAgain ? "成功" : "失败"));

        // 尝试取消
        boolean cancelCompleted = completedOrder.cancel();
        System.out.println("取消结果：" + (cancelCompleted ? "成功" : "失败"));

        // 创建已发货的订单
        Order shippedOrder = new Order("ORD005", 259.99);
        shippedOrder.pay();
        shippedOrder.ship();

        System.out.println("\n3.2 对已发货订单的支付操作：");
        System.out.println("订单状态：" + shippedOrder.getStatusDescription());
        boolean payShipped = shippedOrder.pay();
        System.out.println("支付结果：" + (payShipped ? "成功" : "失败"));
    }

    /**
     * 演示传统方式存在的问题
     *
     * <p>通过代码分析和实际问题展示，说明为什么需要状态模式：
     * 代码重复、违反开闭原则、维护困难等</p>
     */
    private static void demonstrateProblems() {
        System.out.println("\n\n🔍 场景四：传统方式问题分析");
        System.out.println("=====================================");

        System.out.println("传统状态管理方式存在以下问题：");
        System.out.println();

        System.out.println("1️⃣ 代码重复问题：");
        System.out.println("   - 每个业务方法都包含相同的switch结构");
        System.out.println("   - 状态检查逻辑在多个方法中重复");
        System.out.println("   - 违反了DRY（Don't Repeat Yourself）原则");
        System.out.println();

        System.out.println("2️⃣ 违反开闭原则：");
        System.out.println("   - 添加新状态需要修改所有包含switch的方法");
        System.out.println("   - 修改现有状态的逻辑需要查找并修改多个方法");
        System.out.println("   - 难以保证修改的一致性");
        System.out.println();

        System.out.println("3️⃣ 职责分离不清：");
        System.out.println("   - Order类承担了过多的职责");
        System.out.println("   - 状态转换逻辑与业务逻辑混合");
        System.out.println("   - 单一类过于庞大，难以理解和维护");
        System.out.println();

        System.out.println("4️⃣ 状态转换逻辑分散：");
        System.out.println("   - 不同状态的行为规则分散在各个方法中");
        System.out.println("   - 缺乏统一的状态管理机制");
        System.out.println("   - 难以查看和理解完整的状态转换规则");
        System.out.println();

        System.out.println("5️⃣ 扩展性差：");
        System.out.println("   - 添加新的状态相关操作困难");
        System.out.println("   - 修改状态转换规则风险高");
        System.out.println("   - 测试覆盖所有状态组合复杂");
        System.out.println();

        System.out.println("💡 解决方案：状态模式");
        System.out.println("   - 将每个状态封装为独立的类");
        System.out.println("   - 使用多态替代条件判断");
        System.out.println("   - 符合开闭原则和单一职责原则");
        System.out.println("   - 提高代码的可维护性和扩展性");
        System.out.println();

        System.out.println("📚 接下来请查看 optimize 包中的状态模式实现！");
    }
}