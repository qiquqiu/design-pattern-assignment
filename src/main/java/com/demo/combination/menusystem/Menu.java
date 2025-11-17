package com.demo.combination.menusystem;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单类
 * 这是组合模式中的容器节点(Composite)角色，表示可以包含子节点的复合对象
 * 容器节点提供了管理子节点的操作，如添加、删除、获取子节点等
 *
 * 在系统管理菜单中，Menu代表菜单分类，如：
 * - 系统管理
 * - 菜单管理
 * - 权限配置
 * - 角色管理
 */
public class Menu extends MenuComponent {

    /**
     * 子菜单组件列表
     */
    private List<MenuComponent> menuComponents = new ArrayList<>();

    /**
     * 构造函数
     * @param name 菜单名称
     * @param level 菜单层级
     */
    public Menu(String name, int level) {
        super(name, level);
    }

    /**
     * 添加子菜单组件
     * @param menuComponent 要添加的菜单组件
     */
    @Override
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    /**
     * 移除子菜单组件
     * @param menuComponent 要移除的菜单组件
     */
    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    /**
     * 获取指定索引的子菜单组件
     * @param index 索引位置
     * @return 子菜单组件
     */
    @Override
    public MenuComponent getChild(int index) {
        return menuComponents.get(index);
    }

    /**
     * 获取所有子菜单组件
     * @return 子菜单组件列表
     */
    @Override
    public List<MenuComponent> getChildren() {
        return new ArrayList<>(menuComponents); // 返回副本，避免外部修改
    }

    /**
     * 获取子菜单组件数量
     * @return 子组件数量
     */
    public int getChildCount() {
        return menuComponents.size();
    }

    /**
     * 重写显示信息方法，为容器菜单添加标识
     * @return 显示信息
     */
    @Override
    protected String getDisplayInfo() {
        return "+ " + name;
    }

    /**
     * 打印菜单树（递归打印所有子菜单）
     * 这是组合模式的核心方法，通过递归遍历整个树结构
     */
    @Override
    public void print() {
        // 先打印自己
        super.print();

        // 递归打印所有子节点
        for (MenuComponent component : menuComponents) {
            component.print();
        }
    }

    /**
     * 根据名称查找子菜单组件
     * @param name 要查找的组件名称
     * @return 找到的组件，如果没找到返回null
     */
    public MenuComponent findChildByName(String name) {
        for (MenuComponent component : menuComponents) {
            if (component.getName().equals(name)) {
                return component;
            }
        }
        return null;
    }

    /**
     * 获取所有叶子节点（菜单项）
     * @return 所有叶子节点的列表
     */
    public List<MenuItem> getAllLeafItems() {
        List<MenuItem> leafItems = new ArrayList<>();
        collectLeafItems(leafItems);
        return leafItems;
    }

    /**
     * 递归收集所有叶子节点
     * @param leafItems 收集结果列表
     */
    private void collectLeafItems(List<MenuItem> leafItems) {
        for (MenuComponent component : menuComponents) {
            if (component instanceof MenuItem) {
                leafItems.add((MenuItem) component);
            } else if (component instanceof Menu) {
                ((Menu) component).collectLeafItems(leafItems);
            }
        }
    }
}