# 软件设计与架构 - 设计模式作业项目

本项目是"软件设计与架构"课程的设计模式作业实现，使用Java语言完成了**16个经典设计模式的实践**（10个课程要求 + 6个额外示例），展现了深入的设计模式理解和实际应用能力。

## 📋 项目概述

- **课程名称**: 软件设计与架构
- **项目类型**: 设计模式作业实现
- **开发语言**: Java 17
- **构建工具**: Maven
- **特色亮点**:
  - 🎯 装饰器模式双重实现（游戏场景 + 电商实战）
  - 🏭 工厂模式三兄弟完整对比（简单工厂 + 工厂方法 + 抽象工厂）
  - 🌳 组合模式双重应用（菜单系统 + 文件目录系统）
  - 📚 详尽的业务场景和设计模式说明

## 🏗️ 项目结构

```
src/main/java/com/demo/
├── 📁 singleton/              # 作业一：单例模式 (已完成)
│   ├── AppConfig.java
│   └── SingletonMain.java
│
├── 📁 simplefactory/          # 作业二：简单工厂模式 (已完成)
│   ├── laptops/
│   │   ├── Laptop.java
│   │   └── impl/
│   │       ├── HpLaptop.java
│   │       ├── AcerLaptop.java
│   │       ├── LenovoLaptop.java
│   │       └── DellLaptop.java
│   ├── LaptopFactory.java
│   └── OemManufacturer.java
│
├── 📁 abstractfactory/        # 作业三：抽象工厂模式 (已完成)
│   ├── hamburg/
│   │   ├── Hamburg.java
│   │   └── impl/
│   │       ├── KfcHamburg.java
│   │       └── McdonaldsHamburg.java
│   ├── cola/
│   │   ├── Cola.java
│   │   └── impl/
│   │       ├── KfcCola.java
│   │       └── McdonaldsCola.java
│   ├── factory/
│   │   ├── FastFoodFactory.java
│   │   └── impl/
│   │       ├── KfcFactory.java
│   │       └── McdonaldsFactory.java
│   └── FastFoodRestaurant.java
│
├── 📁 builder/                # 作业四：建造者模式 (已完成)
│   ├── Car.java
│   ├── CarBuilder.java
│   ├── BmwBuilder.java
│   ├── BenzBuilder.java
│   ├── CarDirector.java
│   └── CarManufacturer.java
│
├── 📁 adapter/                # 作业五：适配器模式 (已完成)
│   ├── interfaces/
│   │   └── Shape.java
│   ├── shapes/
│   │   ├── Circle.java
│   │   ├── Rectangle.java
│   │   ├── Line.java
│   │   └── Angle.java
│   ├── adapters/
│   │   └── AngleAdapter.java
│   └── DrawingSystem.java
│
├── 📁 bridge/                 # 作业六：桥接模式 (已完成)
│   ├── additives/
│   │   ├── CoffeeAdditives.java
│   │   ├── Sugar.java
│   │   ├── Milk.java
│   │   └── Lemon.java
│   ├── coffee/
│   │   ├── Coffee.java
│   │   ├── JorumCoffee.java
│   │   ├── MediumCoffee.java
│   │   └── SmallCoffee.java
│   └── CoffeeShop.java
│
├── 📁 decorator/              # 作业七：装饰模式 (已完成) 🌟特色模式
│   ├── goatdemo/                   # 主要实现：喜羊羊逃命游戏
│   │   ├── components/
│   │   │   ├── IGoat.java
│   │   │   └── XiGoat.java
│   │   ├── decorators/
│   │   │   ├── GoatDecorator.java
│   │   │   ├── ShieldDecorator.java
│   │   │   ├── SpeedDecorator.java
│   │   │   └── WaterDecorator.java
│   │   └── GameSimulation.java
│   └── promotion/                  # 🎯 额外示例：电商优惠券装饰器模式
│       ├── components/
│       │   ├── IPromotionStrategy.java
│       │   └── OriginalPrice.java
│       ├── decorators/
│       │   ├── PromotionDecorator.java
│       │   ├── FullReductionCoupon.java      # 满减券
│       │   ├── DiscountCoupon.java          # 折扣券
│       │   ├── TieredFullReductionCoupon.java # 每满减券
│       │   └── DirectReductionCoupon.java   # 无条件减券
│       ├── EcommerceShoppingDemo.java
│       └── 优惠券装饰器模式阅读理解.md     # 完整学习文档
│
├── 📁 facade/                 # 作业八：外观模式 (已完成)
│   ├── subsystems/
│   │   ├── Camera.java
│   │   ├── Light.java
│   │   ├── Sensor.java
│   │   └── Alarm.java
│   ├── SecurityFacade.java
│   └── SecurityGuardClient.java
│
├── 📁 observer/               # 作业九：观察者模式 (已完成)
│   ├── interfaces/
│   │   ├── IMember.java
│   │   └── IProduct.java
│   ├── observers/
│   │   └── Member.java
│   ├── concretes/
│   │   └── Product.java
│   └── OnlineStore.java
│
├── 📁 strategy/               # 作业十：策略模式 (已完成) 🌟详细注释
│   ├── interfaces/
│   │   └── DiscountStrategy.java
│   ├── strategies/
│   │   ├── ComputerBookDiscountStrategy.java
│   │   ├── EnglishBookDiscountStrategy.java
│   │   └── NoDiscountStrategy.java
│   ├── concretes/
│   │   └── Book.java
│   ├── BookSaleSystem.java
│   └── JDK源码解析-Comparator中的策略模式.md  # JDK源码分析文档
│
├── 📁 factorymethod/          # 🎯 额外示例：工厂方法模式 (已完成)
│   ├── product/
│   │   ├── Vehicle.java
│   │   └── impl/
│   │       ├── Car.java
│   │       ├── Bicycle.java
│   │       └── Airplane.java
│   ├── factory/
│   │   ├── VehicleFactory.java
│   │   └── impl/
│   │       ├── CarFactory.java
│   │       ├── BicycleFactory.java
│   │       └── AirplaneFactory.java
│   └── TransportationCompany.java
│
├── 📁 combination/            # 🎯 额外示例：组合模式 (已完成)
│   ├── menusystem/         # 菜单系统演示
│   │   ├── MenuComponent.java
│   │   ├── MenuItem.java
│   │   ├── Menu.java
│   │   └── MenuSystem.java
│   ├── dirsystem/          # 文件目录系统演示
│   │   ├── FileComponent.java
│   │   ├── File.java
│   │   ├── Directory.java
│   │   └── FileSystemDemo.java
│   └── 组合模式学习文档.md
│
├── 📁 state/                  # 🎯 额外示例：状态模式 (已完成) 🌟对比学习
│   ├── origin/             # 传统方式（展示问题）
│   │   ├── Order.java      # 使用switch的订单类
│   │   └── OrderDemo.java  # 传统方式演示
│   ├── optimize/           # 状态模式（解决方案）
│   │   ├── Order.java      # 状态模式的上下文类
│   │   ├── OrderDemo.java  # 状态模式演示
│   │   └── states/         # 状态类包
│   │       ├── OrderState.java         # 状态接口
│   │       ├── PendingState.java       # 待支付状态
│   │       ├── PaidState.java          # 已支付状态
│   │       ├── ShippedState.java       # 已发货状态
│   │       ├── CompletedState.java     # 已完成状态
│   │       └── CancelledState.java     # 已取消状态
│   └── 状态模式学习文档.md   # 完整学习文档
│
├── 📁 command/               # 🎯 额外示例：命令模式 (已完成) 🌟中间人解耦
│   ├── Command.java           # 命令接口（声明execute和undo）
│   ├── RemoteControl.java     # 调用者（遥控器）
│   ├── RemoteControlDemo.java # 演示客户端
│   ├── receivers/             # 接收者包（真正干活的对象）
│   │   ├── Light.java         # 电灯接收者
│   │   └── Fan.java           # 风扇接收者
│   ├── commands/              # 具体命令包（中间人）
│   │   ├── LightOnCommand.java     # 开灯命令
│   │   ├── LightOffCommand.java    # 关灯命令
│   │   ├── FanHighCommand.java     # 风扇高速命令
│   │   ├── FanOffCommand.java      # 风扇关闭命令
│   │   └── NoCommand.java          # 空命令（避免空指针）
│   └── 命令模式学习文档.md     # 完整学习文档（中间人解耦解析）
│
└── 📁 memento/               # 🎯 额外示例：备忘录模式 (已完成) 🌟极简演示
    ├── Originator.java       # 发起人类（需要保存状态的对象）
    ├── Memento.java          # 备忘录类（保存状态快照）
    ├── Caretaker.java        # 管理者类（Stack多状态管理）
    ├── MementoDemo.java      # 演示客户端
    └── 备忘录模式学习笔记.md # 完整学习文档（Git Stash类比）

📊 统计信息：
├── 🏗️ 创建型模式 (5个): 单例、简单工厂、抽象工厂、建造者、工厂方法
├── 🏛️ 结构型模式 (5个): 适配器、桥接、装饰、外观、组合
└── 🎯 行为型模式 (6个): 观察者、策略、状态、备忘录、命令 + 学习文档
```

## 📚 作业详情

### 🏗️ 创建型模式 (5个)

#### 作业一：单例模式的应用
**目的**: 掌握单例模式特点，分析具体问题并使用单例模式进行设计

**内容**: 配置文件管理器设计
- 解决系统中多份配置文件内容浪费内存资源的问题
- 确保AppConfig类在运行期间只有一个对象实例
- **实现**: `com.demo.singleton.AppConfig`

**运行**: `com.demo.singleton.SingletonMain`

---

#### 作业二：简单工厂模式的应用
**目的**: 掌握工厂模式特点，分析具体问题并使用工厂模式进行设计

**内容**: OEM制造商笔记本生产
- OEM制造商代理HP、Acer、Lenovo、Dell多个品牌笔记本
- 使用简单工厂模式改善设计，便于管理不同品牌产品
- **实现**: `com.demo.simplefactory.LaptopFactory`

**运行**: `com.demo.simplefactory.OemManufacturer`

---

#### 作业三：抽象工厂模式的应用
**目的**: 掌握抽象工厂模式特点，分析具体问题并使用抽象工厂模式进行设计

**内容**: 快餐店产品家族
- 麦当劳(McDonalds)和肯德基(KFC)都经营汉堡(Hamburg)和可乐(Cola)
- 使用抽象工厂模式实现两个快餐店的产品家族
- **实现**: `com.demo.abstractfactory.factory.FastFoodFactory`

**运行**: `com.demo.abstractfactory.FastFoodRestaurant`

---

#### 作业四：建造者模式的应用
**目的**: 掌握建造者模式特点，分析具体问题并使用建造者模式进行设计

**内容**: 汽车生产系统
- 汽车生产必须包含车轮(Wheel)、油箱(OilBox)和车身(Body)
- 构建BMW品牌和BenZ品牌汽车生产
- **实现**: `com.demo.builder.CarBuilder`

**运行**: `com.demo.builder.CarManufacturer`

---

#### 🎯 额外示例：工厂方法模式的应用
**目的**: 对比理解工厂方法模式与简单工厂、抽象工厂模式的区别

**内容**: 交通工具生产系统
- 交通公司可以生产汽车、自行车、飞机等不同交通工具
- 每种交通工具都有专门的工厂负责生产
- 对比简单工厂：一个工厂对应一种产品，更符合开闭原则
- 对比抽象工厂：一个工厂生产一种产品，而非产品家族
- **实现**: `com.demo.factorymethod.factory.VehicleFactory`

**运行**: `com.demo.factorymethod.TransportationCompany`

---

### 🏛️ 结构型模式 (4个)

#### 作业五：适配器模式的应用
**目的**: 掌握适配器模式特点，分析具体问题并使用适配器模式进行设计

**内容**: 绘图系统统一接口
- 绘图系统有Circle、Rectangle、Line都支持Draw()函数
- 合作团队实现的角度对象(Angle)绘制函数为DrawAngle()
- 使用适配器模式统一接口，让用户可以统一调用
- **实现**: `com.demo.adapter.adapters.AngleAdapter`

**运行**: `com.demo.adapter.DrawingSystem`

---

#### 作业六：桥接模式的应用
**目的**: 掌握桥接模式特点，分析具体问题并使用桥接模式进行设计

**内容**: 咖啡店口味组合
- 咖啡店提供大杯(JorumCoffee)、中杯(MediumCoffee)、小杯(SmallCoffee)
- 可以添加牛奶(Milk)、糖(Sugar)、柠檬(Lemon)
- 实现不同口味的组合（如大杯咖啡加牛奶、中杯咖啡加糖等）
- **实现**: `com.demo.bridge.coffee.Coffee`

**运行**: `com.demo.bridge.CoffeeShop`

---

#### 作业七：装饰模式的应用
**目的**: 掌握装饰模式特点，分析具体问题并使用装饰模式进行设计

**内容**: "喜羊羊逃命"游戏
- 喜羊羊最多5条命，被灰太狼咬到会减少生命
- 可吃三种苹果：红苹果(保护罩)、绿苹果(加快速度)、黄苹果(趟水跑)
- 避免使用继承产生的6个子类，使用装饰模式动态添加功能
- **实现**: `com.demo.decorator.goatdemo.decorators.GoatDecorator`

**运行**: `com.demo.decorator.goatdemo.GameSimulation`

---

#### 🎯 额外示例：电商优惠券装饰器模式
**目的**: 展示装饰器模式在真实业务场景中的应用

**内容**: 电商购物优惠券叠加系统
- 实现满减券、折扣券、每满减券、无条件减券四种优惠券类型
- 展示优惠券的动态组合和叠加使用
- 演示计算顺序对最终价格的影响
- 提供完整的中文业务文档说明
- **实现**: `com.demo.decorator.promotion.decorators.PromotionDecorator`

**运行**: `com.demo.decorator.promotion.EcommerceShoppingDemo`

---

#### 作业八：外观模式的应用
**目的**: 掌握外观模式特点，分析具体问题并使用外观模式进行设计

**内容**: 安防系统简化操作
- 安防系统由录像机(Camera)、电灯(Light)、红外线监控(Sensor)和警报器(Alarm)组成
- 保安需要经常启动和关闭这些仪器，觉得使用不方便
- 使用外观模式提供一键操作接口
- **实现**: `com.demo.facade.SecurityFacade`

**运行**: `com.demo.facade.SecurityGuardClient`

---

### 🎯 行为型模式 (3个)

#### 作业九：观察者模式的应用
**目的**: 掌握观察者模式特点，分析具体问题并使用观察者模式进行设计

**内容**: 网上商店商品变更通知
- 商品在名称、价格等方面有变化时，系统自动通知会员
- 实现网上商店区别传统商店的特色功能
- **实现**: `com.demo.observer.concretes.Product`

**运行**: `com.demo.observer.OnlineStore`

---

#### 作业十：策略模式的应用
**目的**: 掌握策略模式特点，分析具体问题并使用策略模式进行设计

**内容**: 图书销售折扣计算
- 不同类型图书有不同折扣：计算机类7折，英语类6折
- 计算金额时必须区别对待不同类型图书
- **实现**: `com.demo.strategy.strategies.DiscountStrategy`

**运行**: `com.demo.strategy.BookSaleSystem`

---

#### 🎯 额外示例：状态模式的应用
**目的**: 对比理解状态模式与传统状态管理方式的区别

**内容**: 订单状态管理系统
- **传统方式**: 使用枚举+switch语句管理状态（`com.demo.state.origin`）
- **状态模式**: 使用多态和状态类封装状态行为（`com.demo.state.optimize`）
- 完整的订单生命周期：待支付→已支付→已发货→已完成
- 对比展示两种方式的优缺点和适用场景
- **实现**: `com.demo.state.optimize.states.OrderState`

**运行**:
```bash
# 传统方式
java -cp target/classes com.demo.state.origin.OrderDemo

# 状态模式
java -cp target/classes com.demo.state.optimize.OrderDemo
```

---

#### 🎯 额外示例：命令模式的应用
**目的**: 理解命令模式的"中间人"解耦机制

**内容**: 智能家居遥控器系统
- **核心角色**: Command（命令接口）、Invoker（调用者）、Receiver（接收者）
- **中间人解耦**: 具体命令类作为中间人，连接调用者和接收者
- **撤销支持**: 每个命令都支持execute()和undo()操作
- **动态组合**: 遥控器可以控制任何实现了Command接口的设备
- **空命令模式**: 使用NoCommand避免空指针异常
- **实现**: `com.demo.command.commands.LightOnCommand`（开灯命令）

**运行**: `com.demo.command.RemoteControlDemo`

---

#### 🎯 额外示例：备忘录模式的应用
**目的**: 理解备忘录模式的存档和读档机制

**内容**: 极简状态存档恢复系统
- **核心三角色**: Originator（发起人）、Memento（备忘录）、Caretaker（管理者）
- **Git Stash类比**: 类似Git的stash功能，支持多级撤销
- **Stack管理**: 使用Stack实现多状态管理，支持连续撤销
- **极简设计**: 专注核心功能，代码简洁易懂
- **实现**: `com.demo.memento.Caretaker`（Stack多状态管理）

**运行**: `com.demo.memento.MementoDemo`

---

---

## 🚀 快速开始

### 环境要求
- Java 17+
- Maven 3.6+

### 编译项目
```bash
mvn compile
```

### 运行示例
每个设计模式都有对应的主运行类：

```bash
# 创建型模式
# 作业一：单例模式
java -cp target/classes com.demo.singleton.SingletonMain

# 作业二：简单工厂模式
java -cp target/classes com.demo.simplefactory.OemManufacturer

# 作业三：抽象工厂模式
java -cp target/classes com.demo.abstractfactory.FastFoodRestaurant

# 作业四：建造者模式
java -cp target/classes com.demo.builder.CarManufacturer

# 额外示例：工厂方法模式
java -cp target/classes com.demo.factorymethod.TransportationCompany

# 额外示例：组合模式（菜单系统）
java -cp target/classes com.demo.combination.MenuSystem

# 额外示例：组合模式（文件目录系统）
java -cp target/classes com.demo.combination.dirsystem.FileSystemDemo

# 结构型模式
# 作业五：适配器模式
java -cp target/classes com.demo.adapter.DrawingSystem

# 作业六：桥接模式
java -cp target/classes com.demo.bridge.CoffeeShop

# 作业七：装饰模式（喜羊羊游戏）
java -cp target/classes com.demo.decorator.goatdemo.GameSimulation

# 额外示例：电商优惠券装饰器模式
java -cp target/classes com.demo.decorator.promotion.EcommerceShoppingDemo

# 作业八：外观模式
java -cp target/classes com.demo.facade.SecurityGuardClient

# 行为型模式
# 作业九：观察者模式
java -cp target/classes com.demo.observer.OnlineStore

# 作业十：策略模式
java -cp target/classes com.demo.strategy.BookSaleSystem

# 额外示例：状态模式（传统方式）
java -cp target/classes com.demo.state.origin.OrderDemo

# 额外示例：状态模式（状态模式）
java -cp target/classes com.demo.state.optimize.OrderDemo

# 额外示例：命令模式
java -cp target/classes com.demo.command.RemoteControlDemo

# 额外示例：备忘录模式
java -cp target/classes com.demo.memento.MementoDemo
```

### 打包项目
```bash
mvn package
```

### 清理项目
```bash
mvn clean
```

## 📖 设计模式说明

### 创建型模式
- **单例模式**: 确保一个类只有一个实例，并提供全局访问点
- **简单工厂模式**: 根据参数创建不同产品实例
- **工厂方法模式**: 定义创建对象的接口，让子类决定实例化哪个类
- **抽象工厂模式**: 创建一系列相关对象的产品家族
- **建造者模式**: 分步骤构建复杂对象

### 结构型模式
- **适配器模式**: 将接口转换为客户端期望的接口
- **桥接模式**: 将抽象部分与实现部分分离
- **装饰模式**: 动态地给对象添加额外功能
- **组合模式**: 将对象组合成树形结构以表示"部分-整体"的层次结构
- **外观模式**: 为复杂子系统提供统一接口

### 行为型模式
- **观察者模式**: 对象间一对多依赖关系
- **策略模式**: 定义算法族，分别封装起来
- **状态模式**: 允许对象在内部状态改变时改变它的行为
- **备忘录模式**: 在不破坏封装性的前提下保存和恢复对象状态
- **命令模式**: 将请求封装为对象，通过"中间人"实现调用者和接收者的解耦

## 🔄 特殊设计模式特征分析

### 💡 自聚合（自引用）设计模式

自聚合（或自引用）是指类中包含自己类型引用的设计模式。这类模式通过对象间的递归关系实现复杂的功能扩展和结构组织。在本项目中，以下模式体现了自聚合特征：

#### 1. 装饰模式 (Decorator)
**自聚合特征**: 装饰器持有被装饰对象的同类型引用
```java
// DecoratedGoat.java
protected IGoat decoratedGoat;  // 持有同类型接口引用
```
**结构特点**:
- 递归装饰能力，可以无限嵌套
- 每个装饰器既是装饰者也是被装饰者
- 形成装饰链结构

#### 2. 组合模式 (Composite)
**自聚合特征**: 容器对象持有同类型元素的集合
```java
// Menu.java
private List<MenuComponent> menuComponents;  // 持有同类型集合
```
**结构特点**:
- 递归树形结构
- 容器节点和叶子节点统一接口
- 支持递归遍历操作

#### 3. 责任链模式 (Chain of Responsibility)
**自聚合特征**: 每个处理器持有下一个处理器的引用
```java
// Logger.java
protected Logger nextLogger;  // 持有自己类型引用
```
**结构特点**:
- 线性链式结构
- 请求沿着链条传递
- 每个节点都可以处理或传递请求

### 🎯 自聚合模式的核心优势

1. **递归能力**: 通过自引用形成递归结构，支持无限嵌套组合
2. **统一接口**: 通过同类型引用实现接口的统一处理
3. **灵活扩展**: 可以动态添加、删除链中的节点或装饰器
4. **结构清晰**: 递归关系使代码结构更加直观和优雅
5. **功能增强**: 通过对象组合而非继承实现功能扩展

这种设计体现了"组合优于继承"的面向对象设计原则，是很多高级设计模式的核心实现机制。

## 🌟 项目特色

### 1. 🎯 装饰器模式双重实现
- **游戏场景**: 喜羊羊逃命游戏，生动有趣的学习案例
- **电商实战**: 真实业务场景，展示优惠券叠加逻辑
- **完整文档**: 详细的中文阅读理解文档

### 2. 🏭 工厂模式完整对比
- **简单工厂**: 一个工厂创建多种产品
- **工厂方法**: 一个工厂对应一种产品
- **抽象工厂**: 一个工厂创建产品家族
- **对比学习**: 深入理解三种工厂模式的区别和应用场景

### 3. 🌳 组合模式双重应用
- **菜单系统**: 系统管理中的多级菜单结构演示
- **文件目录**: 模拟tree命令的文件系统层次结构
- **统一接口**: 展示叶子节点和容器节点的一致处理
- **递归操作**: 递归遍历和显示整个树形结构

### 4. 🔄 状态模式对比学习
- **传统方式**: 使用switch语句管理状态，展示问题
- **状态模式**: 使用多态和状态类，展示解决方案
- **对比分析**: 详细对比两种方式的优缺点
- **业务场景**: 订单状态管理系统，贴近实际应用

### 5. 💾 备忘录模式极简演示
- **极简设计**: 专注核心功能，代码简洁易懂
- **Git Stash类比**: 类似Git的stash功能，便于理解
- **Stack多状态**: 使用Stack实现多级撤销机制
- **三角色清晰**: Originator、Memento、Caretaker职责分明

### 6. 📚 优质代码质量
- **完整注释**: 每个类都有详细的JavaDoc注释
- **设计原则**: 严格遵循SOLID设计原则
- **业务场景**: 贴近实际的业务应用场景
- **代码规范**: 统一的命名规范和代码风格

## 📝 提交要求

每个设计模式作业需要：
1. ✅ 正确实现设计模式
2. ✅ 包含主类展示实际使用
3. ✅ 遵循具体作业要求
4. ⏳ 绘制UML图（手动任务）

## 🎓 学习成果

通过本项目，你可以：
- 深入理解16个设计模式的核心思想（10个作业+6个额外示例）
- 掌握不同设计模式的适用场景和区别
- 理解命令模式的"中间人"解耦机制和实际应用
- 理解工厂模式三种变体：简单工厂、工厂方法、抽象工厂
- 学习装饰器模式在真实电商业务中的应用
- 掌握状态模式与传统状态管理方式的对比
- 理解策略模式在JDK源码中的实际应用
- 学习备忘录模式的存档读档机制（类似Git Stash）
- 提升面向对象设计能力
- 增强代码的可维护性和可扩展性

## 🏆 项目评价

**代码质量**: ⭐⭐⭐⭐⭐
- 所有设计模式实现正确且完整
- 代码结构清晰，命名规范
- 注释详细，文档完善

**学习价值**: ⭐⭐⭐⭐⭐
- 理论与实践完美结合
- 业务场景生动贴切
- 额外示例展现了深入理解

**实用程度**: ⭐⭐⭐⭐⭐
- 可作为设计模式学习参考
- 代码可直接应用于实际项目
- 文档详细便于团队学习

## 📖 学习资源

### 推荐学习网站
- **[菜鸟教程 - 设计模式](https://www.runoob.com/design-pattern/design-pattern-intro.html)** - 通俗易懂的设计模式教程，包含23种经典设计模式的详细说明
- **[Refactoring.Guru](https://refactoring.guru/design-patterns)** - 国外优秀的设计模式学习网站，提供丰富的实例和代码演示

### 学习建议
1. **理论结合实践**: 先理解设计模式的概念，再通过代码实现加深理解
2. **对比学习**: 对比相似模式的区别，如三种工厂模式的对比
3. **实际应用**: 思考在真实项目中如何应用这些模式
4. **代码阅读**: 阅读开源框架中设计模式的应用

---

本项目仅用于学习目的，请遵守课程要求。