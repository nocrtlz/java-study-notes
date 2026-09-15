# Day3学习笔记

## 📖 知识点梳理（建议 2h）

### 1. 抽象类 abstract

1. 用`abstract class`定义，**不能 new 实例对象**
2. 可以有普通成员变量、普通方法、构造方法（供子类 super 调用）
3. 可以有抽象方法：`abstract void test();`，没有方法体
4. 子类继承抽象类（extends），**必须重写所有抽象方法**；除非子类也定义为 abstract 抽象类
5. 抽象类只是不能实例化，不是所有方法都必须是抽象方法

### 2. 接口 interface（Java8 前后变化重点，面试高频）

> Java 8：接口可以有抽象方法、默认方法 (default)、静态方法 (static)；不能有实例成员变量 Java 9+：可以有私有方法（了解即可）

1. `interface`定义，**不能 new 对象**
2. 接口里的变量默认：`public static final`（常量，必须初始化，不能修改）
3. 抽象方法默认：`public abstract`
4. 类实现接口用 `implements`，**一个类可以实现多个接口**（弥补 Java 单继承局限）
5. 实现类必须重写接口全部抽象方法，除非实现类是 abstract 抽象类
6. 默认方法：`default void func(){}`，有方法体，实现类可以直接用或者重写；只能通过对象调用
7. 静态方法：`static void func(){}`，只能**接口名。静态方法**调用，实现类对象无法调用

> ✅ 抽象类 VS 接口 核心对比（你要整理进笔记表格） | 对比项 | 抽象类 abstract class | 接口 interface| | ---- | ---- | ---- | | 关键字 | extends 继承 | implements 实现，可多实现 | | 构造方法 | 有 | 无 | | 成员变量 | 普通变量、常量都可以 | 只能是 public static final 常量 | | 方法 | 普通方法、抽象方法 | Java8：抽象、default、static| | 设计思想 |**is-a 是一个**，对事物抽象 |**has-a 具备某种能力**，行为规范 |

### 3. static 关键字（静态）

修饰：变量、方法、代码块、内部类

1. **属于类，不属于对象**；类加载的时候就创建，优先于对象存在

2. 静态变量：所有对象共享同一份内存

3. 静态方法：

   ```
   public static void test(){}
   ```

   - 调用方式：`类名.方法()`，也可以对象调用（不推荐）
   - ⚠️ 静态方法**不能直接访问非静态成员**；不能使用 this、super

4. 静态代码块 `static{}`：类加载时执行**仅一次**，用于初始化静态资源

> 口诀：静态只能访问静态

### 4. final 关键字（最终，不可修改）

修饰：类、方法、变量

1. final 修饰**类**：不能被继承（无子类）

2. final 修饰**方法**：不能被子类重写 override

3. final 修饰

   变量

   ：常量，只能赋值一次

   - 基本类型：值不可变
   - 引用类型：**地址不可变**，对象内部属性仍然可以修改（面试坑点！）

## 🧩 今日代码练习（必敲，理解差异）

任务：写一段代码，同时使用抽象类、接口、static、final 需求：

1. 定义接口 `Run`，里面抽象方法`run()`；default 方法`show()`
2. 抽象类 `Animal`，包含 final 成员变量，static 静态方法`info()`，抽象方法`eat()`
3. 类 `Dog` 继承 Animal，实现 Run 接口；重写 run ()、eat ()
4. 测试类：调用静态方法、常量；创建 Dog 对象调用重写方法、接口默认方法

##### 字符串：去除字符串首尾空格，把全部大写转小写

```
public class reString {
    public static void main(String[] args) {
        String s1="HelloWord 1234 5 6ILOVEYOU";
        String s2=s1.trim();
        String S3=s2.toLowerCase();
        System.out.println(S3);
    }
}
```

- `trim()`：去除字符串首尾的空白字符（空格、制表符等）
- `toLowerCase()`：将所有英文字母转为小写

##### 数组：查找目标元素在数组中的索引，找不到返回 - 1（简单查找)

```
import java.util.Scanner;
public class Arr {
    public static void main(String[] args) {
        int[] arr = {10, 11, 15, 19, 198, 25};
        int index=-1;
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == a) {
                index=i;
                System.out.println(index);
                break;
            }
        }
        sc.close();
    }
}
```

## ⚠️ 突击重点提醒（面试高频坑）

1. static 方法不存在重写！子类定义同名 static 方法，叫**隐藏**，不是重写 override
2. 接口中变量默认自带 public static final，就算不写也是
3. final 引用变量只是地址不能改，对象内容可变，这个点面试很爱问