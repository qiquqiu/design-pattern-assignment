package com.demo.combination.menusystem;

/**
 * 菜单项类
 * 这是组合模式中的叶子节点(Leaf)角色，表示树形结构中的叶子对象
 * 叶子节点没有子节点，实现了抽象组件中定义的行为
 *
 * 在系统管理菜单中，MenuItem代表具体的操作项，如：
 * - 页面访问
 * - 展开菜单
 * - 编辑菜单
 * - 删除菜单
 * - 新增菜单
 * - 提交保存
 * - 新增角色
 * - 修改角色
 */
public class MenuItem extends MenuComponent {
    /**
     * 构造函数
     * @param name 菜单项名称
     * @param level 菜单层级
     */
    public MenuItem(String name, int level) {
        super(name, level);
    }

    // 其他方法，如add等方法，默认使用父类的：不支持，即可
}