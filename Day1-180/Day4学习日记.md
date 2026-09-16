# Day4学习日记

## 📖 知识点梳理（建议 2h，面试高频集中区）

### 1. String 字符串（重点：不可变性）

- **底层实现**：Java 8 及之前为 `private final char[] value`；Java 9+ 优化为 `byte[]` 节省内存

- **不可变性**：类被 final 修饰，value 数组也被 final 修饰，字符串对象一旦创建，内容不可修改；任何修改操作（substring、replace 等）都会返回**新的 String 对象**

- 字符串常量池

  ：堆内存中的专门区域

  - 字面量创建 `String s = "abc"`：先检查常量池，有则直接引用，没有则创建后入池
  - `new String("abc")`：至少创建 1 个对象；池中无则先在池中建 "abc"，再在堆中创建新对象

- **常用方法**：`length()`、`charAt()`、`substring()`、`equals()`、`split()`、`trim()`、`replace()`、`intern()`

- **+ 号拼接**：底层自动转 StringBuilder 实现，但**循环中使用 + 会创建大量临时对象，性能极差**

### 2. StringBuilder & StringBuffer

- **可变字符序列**：底层是可变数组，默认初始容量 16，扩容为 原容量 ×2+2

- 核心区别

  - `StringBuilder`：线程不安全，无同步锁，性能高，**单线程场景推荐**
  - `StringBuffer`：线程安全（方法加 synchronized），性能低，仅多线程场景使用

- **常用方法**：`append()`（追加）、`insert()`（插入）、`delete()`（删除）、`reverse()`（反转）、`toString()`

- ##### 字符串分解：split（）

### 3. Object 类（所有类的根父类）

所有类默认直接或间接继承 Object，核心方法：

1. `equals(Object obj)`
   - 默认实现：等价于`==`，比较对象内存地址
   - 重写意义：自定义 “对象内容相等” 的规则（比如 String 重写后比较每个字符）
2. `hashCode()`
   - 返回 int 类型哈希值，默认由对象内存地址映射生成
   - 作用：用于哈希集合（HashMap、HashSet）快速定位存储位置
3. **`toString()`**：默认返回 `类名@哈希值十六进制`，建议重写输出对象属性
4. **`getClass()`**：返回对象运行时类，final 方法，不可重写

### ⚠️ 面试必背：equals 与 hashCode 约定

1. 两个对象`equals`为 true → `hashCode`一定相等
2. 两个对象`hashCode`相等 → `equals`不一定为 true（哈希碰撞）
3. **重写 equals 必须同时重写 hashCode**，否则哈希集合（HashSet、HashMap）会出现去重失效、数据丢失

最规范的 `equals` + `hashCode` 重写：

```
import java.util.Objects;

public class Person {
    private String name;
    private int age;

    // 构造方法、getter/setter 省略...

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        // 用 name 和 age 判断相等
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        // 用同样的 name 和 age 生成哈希
        return Objects.hash(name, age);
    }
}
```

## 🧩 今日代码练习（必敲，理解核心）

### 任务 1：重写 equals 与 hashCode（核心题）

定义`User`类，属性：`int id`、`String username`

要求：id 和 username 均相同则认为两个对象相等，重写`equals()`和`hashCode()`，并创建对象测试

### 任务 2：字符串操作综合练习

给定字符串`" Hello Java World "`，完成以下操作并输出：

1. 去除首尾空格

   tirm();

2. 全部转小写

   toLowerCase()

3. 截取`"Java"`子串

   sub

4. 判断是否以`"Hello"`开头

5. 把所有空格替换为`-`

### 任务 3：拼接性能对比

分别用`+号循环拼接`和`StringBuilder.append`拼接 1~1000 的数字，简单计时体会性能差异

```
public class ConcatPerformance {
    public static void main(String[] args) {
        int count = 1000; // 拼接 1~1000

        // ========== 测试1：+ 号循环拼接 ==========
        long start1 = System.currentTimeMillis();
        String str = "";
        for (int i = 1; i <= count; i++) {
            str += i; // 每次拼接都会生成新的 String 对象
        }
        long end1 = System.currentTimeMillis();
        System.out.println("使用 + 拼接耗时：" + (end1 - start1) + " 毫秒");
        System.out.println("最终字符串长度：" + str.length());

        System.out.println("------------------------");

        // ========== 测试2：StringBuilder.append 拼接 ==========
        long start2 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= count; i++) {
            sb.append(i); // 直接在原缓冲区追加，不生成新对象
        }
        long end2 = System.currentTimeMillis();
        System.out.println("使用 StringBuilder 拼接耗时：" + (end2 - start2) + " 毫秒");
        System.out.println("最终字符串长度：" + sb.length());
    }
}
```

1. #### 哈希：统计字符串中每个字符出现的次数，结果存入 HashMap !!!

```
import java.util.HashMap;

public class HashMaxCount {
    public static void main(String[] args) {
        String s1 = "Hello world xiaoli wwwqtyu";
        // key：字符  value：对应出现次数
        HashMap<Character, Integer> countMap = new HashMap<>();

        // 遍历字符串的每一个字符
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);

            // 判断字符是否已经统计过
            if (countMap.containsKey(c)) {
                // 已存在：取出旧次数 +1，覆盖更新
                int oldCount = countMap.get(c);
                countMap.put(c, oldCount + 1);
            } else {
                // 第一次出现：存入，次数初始化为1
                countMap.put(c, 1);
            }
        }

        // 遍历输出统计结果
        System.out.println("各字符出现次数：");
        for (HashMap.Entry<Character, Integer> entry : countMap.entrySet()) {
            System.out.println("字符 '" + entry.getKey() + "' 出现 " + entry.getValue() + " 次");
        }
    }
}
```

## 当天 3 个自测思考题

1. #### String 为什么设计成不可变？这样设计有什么好处？

   1. **支持字符串常量池，大幅节省内存** Java 有字符串常量池机制：相同内容的字符串可以共享同一个池中的对象，避免重复创建。 如果 String 是可变的，一个引用修改了对象内容，所有指向该对象的其他引用都会跟着变化，常量池就无法安全使用。
   2. **天然线程安全** 不可变对象在多线程并发读取时，不会出现数据不一致的问题，不需要加锁同步，并发性能更高。
   3. **哈希值可缓存，性能更高** String 重写了 `hashCode()`，因为内容不可变，第一次计算哈希值后就会缓存到对象内部，后续直接返回缓存值，无需重复计算。 这也是 String 非常适合作为 HashMap 键的核心原因。
   4. **安全性保障** 字符串常用来传递敏感信息（数据库账号、密码、文件路径），不可变可以避免信息被半路意外修改；类加载时用字符串做类名，不可变也保证了不会加载错误的类。

2. #### `==` 和 `equals` 的区别是什么？String 类的 equals 比较的是什么？

   #### 核心区别

   表格

   | 对比项       | ==（运算符）                           | equals（方法）                                               |
   | ------------ | -------------------------------------- | ------------------------------------------------------------ |
   | **作用对象** | 基本数据类型、引用类型都能用           | 只能用于引用类型对象                                         |
   | **基本类型** | 比较**数值本身**是否相等               | 基本类型不能调用                                             |
   | **引用类型** | 比较**内存地址**，判断是不是同一个对象 | 默认实现（Object 类）和 == 等价，比地址；重写后可以自定义规则，通常比内容 |

   #### String 类的 equals 比较的是什么

   String 类重写了 `equals()` 方法，**逐个对比两个字符串的每一个字符**，只要字符序列、长度完全一致，就返回 `true`，不关心两个字符串是不是同一个内存对象。

3. #### 为什么重写 equals 时必须重写 hashCode？不重写在 HashSet 中会出现什么问题？

   ##### 先明确 Java 官方约定

   这是一条所有哈希集合正常工作的基础规范：

   - 两个对象 `equals()` 返回 `true` → `hashCode()` 必须相等
   - 两个对象 `hashCode()` 相等 → `equals()` 不一定为 `true`（哈希碰撞，属于正常现象）

   ##### 为什么必须同时重写？

   哈希集合（HashSet、HashMap、HashTable）的存储逻辑分两步：

   1. 调用 `hashCode()` 计算哈希值，直接定位到数组的对应下标位置（桶位）
   2. 在该位置上，用 `equals()` 和已有元素逐个比对内容，判断是否重复

   如果只重写 `equals()` 不重写 `hashCode()`：

   - 两个 “内容相等” 的对象，会沿用 Object 类默认的 hashCode（按内存地址生成），导致哈希值不同
   - 哈希值不同就会被分配到数组的不同位置，根本没有机会进行 equals 比对
   - 最终两个逻辑上重复的对象都会被存入集合，**去重功能完全失效**

   #####  HashSet 中的具体问题示例

   比如有个 Person 类，只重写了 equals（姓名年龄相同即相等），没重写 hashCode：

   ```
   Person p1 = new Person("张三", 20);
   Person p2 = new Person("张三", 20);
   
   System.out.println(p1.equals(p2)); // true：业务上认为是同一个人
   
   HashSet<Person> set = new HashSet<>();
   set.add(p1);
   set.add(p2);
   System.out.println(set.size()); // 输出 2，本应去重为 1 个
   ```

   原因：两个对象 hashCode 不同，被放到了 HashSet 的不同桶位，系统直接判定为两个完全不同的对象。

##  突击重点提醒（面试高频坑）

1. 循环拼接字符串严禁用 +，必须用 StringBuilder
2. `String s = new String("a")` 创建对象数量是经典面试题
3. HashSet 去重逻辑：先比 hashCode，不同则直接存入；相同再调用 equals 判断