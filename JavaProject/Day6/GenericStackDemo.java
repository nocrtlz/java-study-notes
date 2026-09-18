package Day6;

import java.util.ArrayList;
import java.util.List;

public class GenericStackDemo {
    // ========== 第一部分：泛型栈 GenericStack<T> ==========
    // 用 List<T> 实现，自动扩容，比数组更安全简单
    static class GenericStack<T> {
        private List<T> data;  // 用 List 存储栈元素

        public GenericStack() {
            data = new ArrayList<>();
        }

        // 入栈：压入元素
        public void push(T item) {
            data.add(item);  // 加到列表末尾
        }

        // 出栈：弹出并返回栈顶元素
        public T pop() {
            if (isEmpty()) {
                throw new RuntimeException("栈已经空了，不能再pop了");
            }
            // 移除最后一个元素并返回
            return data.remove(data.size() - 1);
        }

        // 查看栈顶元素（不弹出）
        public T peek() {
            if (isEmpty()) {
                throw new RuntimeException("栈已经空了，没有元素可看");
            }
            return data.get(data.size() - 1);
        }

        // 判断栈是否为空
        public boolean isEmpty() {
            return data.isEmpty();
        }

        // 栈的大小
        public int size() {
            return data.size();
        }
    }

    // ========== 第二部分：泛型方法 getFirst ==========
    // 接收任意类型的 List，返回第一个元素
    public static <T> T getFirst(List<T> list) {
        if (list == null || list.isEmpty()) {
            return null;  // 空列表返回 null，避免越界
        }
        return list.get(0);
    }

    // ========== 第三部分：? extends Number 求和 ==========
    // 接收任意 Number 子类的 List（Integer、Double、Float 等都行）
    public static double sum(List<? extends Number> list) {
        double total = 0;
        for (Number n : list) {
            total += n.doubleValue();  // 统一转成 double 求和
        }
        return total;
    }

    // ========== 测试主方法 ==========
    public static void main(String[] args) {
        System.out.println("===== 测试1：泛型栈 =====");
        GenericStack<String> stack = new GenericStack<>();
        stack.push("第一");
        stack.push("第二");
        stack.push("第三");

        System.out.println("栈顶元素：" + stack.peek());   // 第三
        System.out.println("栈大小：" + stack.size());     // 3
        System.out.println("弹出：" + stack.pop());        // 第三
        System.out.println("弹出后栈顶：" + stack.peek()); // 第二
        System.out.println("弹出：" + stack.pop());        // 第二
        System.out.println("弹出：" + stack.pop());        // 第一
        // System.out.println(stack.pop());                // 会抛异常：栈空了

        System.out.println("\n===== 测试2：泛型方法 getFirst =====");
        List<Integer> numList = List.of(10, 20, 30);
        List<String> strList = List.of("苹果", "香蕉", "橙子");

        System.out.println("数字列表第一个：" + getFirst(numList));  // 10
        System.out.println("字符串列表第一个：" + getFirst(strList)); // 苹果

        System.out.println("\n===== 测试3：? extends Number 求和 =====");
        List<Integer> ints = List.of(1, 2, 3, 4, 5);
        List<Double> doubles = List.of(1.5, 2.5, 3.0);

        System.out.println("整数列表求和：" + sum(ints));     // 15.0
        System.out.println("小数列表求和：" + sum(doubles));  // 7.0
    }
}
