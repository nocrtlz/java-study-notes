# Day5学习笔记

### Java异常体系

java.lang包中定义了一系列类

Throwable类位于异常类层次最顶端，他派生的的子类可作为一个异常被抛出 

Throwable类有Error类和Exception类两直接子类

Error类描述的是由系统发生的内部错误，不进行异常处理

Exception类可以由用户应用程序抛出并处理

![img](https://www.runoob.com/wp-content/uploads/2013/12/exception-hierarchy.png)

- **try**：用于包裹可能会抛出异常的代码块。

- **catch**：用于捕获异常并处理异常的代码块。

- **finally**：用于包含无论是否发生异常都需要执行的代码块。

- **throw**：用于手动抛出异常。

- **throws**：用于在方法声明中指定方法可能抛出的异常。

- **Exception**类：是所有异常类的父类，它提供了一些方法来获取异常信息，如 **getMessage()、printStackTrace()** 等。

  Java异常体系顶层是 `Throwable`，下分 `Error` 和 `Exception`。`Exception` 又分 **Checked异常**（编译期强制处理）和 **Unchecked异常**（RuntimeException及其子类，运行时才暴露）。常见面试点：Checked异常必须 try-catch 或 throws 处理，否则编译不通过；RuntimeException 不需要强制处理

##### try-catch-finally。 核心语法结构，注意几个易错点：finally 块无论是否发生异常都会执行（除非JVM退出）；finally 中不要写 return，会覆盖 try 中的返回值；多个 catch 时子类异常必须写在父类前面。

##### throw 与 throws 的区别。

throw 用于方法体内主动抛出一个异常对象；throws 用于方法签名上声明该方法可能抛出的异常类型，交给调用者处理。

#### **第1题：两数之和（LeetCode 1，简单）。** 

数组+哈希表经典题，用 HashMap 存“目标值-当前值”实现 O(n) 解法。这题几乎是所有刷题路线的第一题

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
    
            if (map.containsKey(need)) {
                return new int[]{map.get(need), i};
            }
    
            map.put(nums[i], i);
        }
    
        return new int[]{};
    }
}

#### **无重复字符的最长子串（LeetCode 3，中等）**

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();

        int left = 0;
        int maxLen = 0;
    
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
    
            if (lastIndex.containsKey(c)) {
                // 如果这个字符之前出现过，left 要跳到它上次出现位置的下一位
                left = Math.max(left, lastIndex.get(c) + 1);
            }
    
            lastIndex.put(c, right);
    
            int currentLen = right - left + 1;
            maxLen = Math.max(maxLen, currentLen);
        }
    
        return maxLen;
    }
}