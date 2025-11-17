package com.demo.combination.menusystem;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单组件抽象类
 * 这是组合模式中的抽象组件(Component)角色，定义了叶子节点和容器节点的共同接口
 *
 * 组合模式核心思想：
 * 1. 将对象组合成树形结构以表示"部分-整体"的层次结构
 * 2. 使得用户对单个对象和组合对象的使用具有一致性
 * 3. 叶子节点(MenuItem)和容器节点(Menu)都继承自同一抽象类
 */
@Data
public abstract class MenuComponent {

    /**
     * 菜单名称
     */
    protected String name;

    /**
     * 菜单层级（用于显示缩进）
     */
    protected int level;

    /**
     * 构造函数
     * @param name 菜单名称
     * @param level 菜单层级
     */
    public MenuComponent(String name, int level) {
        this.name = name;
        this.level = level;
    }

    /**
     * 添加子菜单项
     * 叶子节点(MenuItem)需要重写此方法并抛出异常
     * 容器节点(Menu)可以实现此方法
     *
     * @param menuComponent 要添加的菜单组件
     */
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException("叶子节点不支持添加操作");
    }

    /**
     * 移除子菜单项
     * 叶子节点(MenuItem)需要重写此方法并抛出异常
     * 容器节点(Menu)可以实现此方法
     *
     * @param menuComponent 要移除的菜单组件
     */
    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException("叶子节点不支持移除操作");
    }

    /**
     * 获取子菜单项
     * 叶子节点(MenuItem)需要重写此方法并抛出异常
     * 容器节点(Menu)可以实现此方法
     *
     * @param index 子菜单项索引
     * @return 子菜单项
     */
    public MenuComponent getChild(int index) {
        throw new UnsupportedOperationException("叶子节点不支持获取子项操作");
    }

    /**
     * 获取所有子菜单项
     * 容器节点(Menu)可以实现此方法
     *
     * @return 子菜单项列表
     */
    public List<MenuComponent> getChildren() {
        return new ArrayList<>(); // 返回空列表，避免空指针异常
    }

    /**
     * 打印菜单信息（包含缩进）
     * 这是一个模板方法，定义了显示的基本格式
     */
    public void print() {
        // 添加缩进
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println(getDisplayInfo());
    }

    /**
     * 获取显示信息
     * 子类可以重写此方法来提供具体的显示信息
     *
     * @return 显示信息字符串
     */
    protected String getDisplayInfo() {
        return name;
    }
}