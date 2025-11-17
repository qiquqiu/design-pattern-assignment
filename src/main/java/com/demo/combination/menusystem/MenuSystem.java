package com.demo.combination.menusystem;

/**
 * 系统管理菜单客户端演示类
 *
 * 组合模式演示：构建系统管理菜单结构
 *
 * 菜单结构：
 * - 系统管理
 *   - 菜单管理
 *     - 页面访问
 *     - 展开菜单
 *     - 编辑菜单
 *     - 删除菜单
 *     - 新增菜单
 *   - 权限配置
 *     - 页面访问
 *     - 提交保存
 *   - 角色管理
 *     - 页面访问
 *     - 新增角色
 *     - 修改角色
 */
public class MenuSystem {

    public static void main(String[] args) {
        System.out.println("=== 组合模式演示：系统管理菜单 ===\n");

        // 创建根菜单：系统管理
        Menu systemManagement = new Menu("系统管理", 0);

        // 创建一级菜单
        Menu menuManagement = new Menu("菜单管理", 1);
        Menu permissionConfig = new Menu("权限配置", 1);
        Menu roleManagement = new Menu("角色管理", 1);

        // 创建菜单管理下的菜单项
        MenuItem menuPageAccess = new MenuItem("页面访问", 2);
        MenuItem menuExpand = new MenuItem("展开菜单", 2);
        MenuItem menuEdit = new MenuItem("编辑菜单", 2);
        MenuItem menuDelete = new MenuItem("删除菜单", 2);
        MenuItem menuAdd = new MenuItem("新增菜单", 2);

        // 创建权限配置下的菜单项
        MenuItem permissionPageAccess = new MenuItem("页面访问", 2);
        MenuItem permissionSave = new MenuItem("提交保存", 2);

        // 创建角色管理下的菜单项
        MenuItem rolePageAccess = new MenuItem("页面访问", 2);
        MenuItem roleAdd = new MenuItem("新增角色", 2);
        MenuItem roleEdit = new MenuItem("修改角色", 2);

        // 构建菜单树（使用组合模式的核心特性）
        // 将一级菜单添加到根菜单
        systemManagement.add(menuManagement);
        systemManagement.add(permissionConfig);
        systemManagement.add(roleManagement);

        // 将菜单项添加到对应的菜单中
        menuManagement.add(menuPageAccess);
        menuManagement.add(menuExpand);
        menuManagement.add(menuEdit);
        menuManagement.add(menuDelete);
        menuManagement.add(menuAdd);

        permissionConfig.add(permissionPageAccess);
        permissionConfig.add(permissionSave);

        roleManagement.add(rolePageAccess);
        roleManagement.add(roleAdd);
        roleManagement.add(roleEdit);

        System.out.println("1. 显示完整的菜单树结构：");
        System.out.println("============================");
        systemManagement.print();

        System.out.println("\n2. 组合模式特性演示：");
        System.out.println("====================");

        // 演示组合模式的统一接口特性
        System.out.println("统一操作接口演示 - 可以对单个对象和组合对象使用相同操作：");
        System.out.println();

        // 单个菜单项操作
        System.out.println("→ 单个菜单项操作：");
        MenuItem singleItem = new MenuItem("单独菜单项", 0);
        singleItem.print();

        // 菜单组合操作
        System.out.println("→ 菜单组合操作：");
        Menu subMenu = new Menu("子菜单", 0);
        subMenu.add(new MenuItem("子项1", 1));
        subMenu.add(new MenuItem("子项2", 1));
        subMenu.print();

        System.out.println("\n3. 动态菜单管理演示：");
        System.out.println("====================");

        // 演示动态添加菜单
        System.out.println("动态添加新的菜单模块：");
        Menu systemConfig = new Menu("系统配置", 1);
        systemConfig.add(new MenuItem("参数设置", 2));
        systemConfig.add(new MenuItem("日志管理", 2));

        systemManagement.add(systemConfig);
        System.out.println("添加系统配置模块后的菜单结构：");
        systemManagement.print();

        System.out.println("\n4. 菜单项统计功能：");
        System.out.println("==================");
        System.out.println("系统管理下的一级菜单数量: " + systemManagement.getChildCount());

        System.out.println("\n菜单管理模块的菜单项：");
        menuManagement.print();
        System.out.println("菜单管理模块包含的操作项数量: " + menuManagement.getAllLeafItems().size());

        System.out.println("\n5. 查找功能演示：");
        System.out.println("================");
        MenuComponent found = systemManagement.findChildByName("角色管理");
        if (found != null) {
            System.out.println("找到 '角色管理' 菜单：");
            found.print();
        }

        System.out.println("\n6. 组合模式优势总结：");
        System.out.println("==================");
        System.out.println("✓ 统一接口：客户端可以一致地处理单个对象和组合对象");
        System.out.println("✓ 灵活性：可以轻松添加新的菜单项或菜单组");
        System.out.println("✓ 层次结构：清晰地表达部分-整体的层次关系");
        System.out.println("✓ 递归操作：通过递归实现对整个树结构的统一操作");
        System.out.println("✓ 易于扩展：新增叶子节点或容器节点都很容易");

        System.out.println("\n7. 实际应用场景：");
        System.out.println("================");
        System.out.println("• 文件系统：文件夹和文件的层次结构");
        System.out.println("• 组织架构：部门和员工的树形关系");
        System.out.println("• GUI组件：容器和组件的嵌套结构");
        System.out.println("• 商品分类：分类和商品的层次关系");
    }
}