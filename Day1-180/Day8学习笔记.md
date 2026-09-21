# Day8学习笔记

### List

size获取长度

List有ArrayList和LinkedList，大多数用ArrayList

常用接口方法

- 在末尾添加一个元素：`boolean add(E e)`
- 在指定索引添加一个元素：`boolean add(int index, E e)`
- 删除指定索引的元素：`E remove(int index)`
- 删除某个元素：`boolean remove(Object e)`
- 获取指定索引的元素：`E get(int index)`
- 获取链表大小（包含元素的个数）：`int size()`

List.of可以快速创建List，但是不接受null，否则会抛出NullPointerException

遍历List用Iterator对象最高效

Iterator有两个方法 boolean hasNext（）判断是否有下一个元素 E next（）返回下一个元素

List和Array转换：

```java
List<Integer> list = List.of(12, 34, 56);
        Integer[] array = list.toArray(new Integer[3]);
        for (Integer n : array) {
            System.out.println(n);
        }
```

常用的是传入一个大小刚好的数组

```java
Integer[] array = list.toArray(new Integer[list.size()]);
```

### Map

Map是key value 映射表的数据结构

put（K key，V value）就是把key和value做个映射放进map

重复放入不会有问题，一个key对应一个value，新的key-value会把原有的替换

遍历map的key可用for each循环map的keySet（）返回Set集合

```java
for (String key : map.keySet()) {
            Integer value = map.get(key);
            System.out.println(key + " = " + value);
        }
```

同时遍历`key`和`value`可以使用`for each`循环遍历`Map`对象的`entrySet()`集合，它包含每一个`key-value`映射：

```java
 for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " = " + value);
        }
```

重新编写hashCode和equals

```java
public boolean equals(Object o) {
    if (o instanceof Person p) {
        return Objects.equals(this.name, p.name) && this.age == p.age;
    }
    return false;
}
```

```java
int hashCode() {
    return Objects.hash(firstName, lastName, age);
}
```

### Set

Set和Map的key类似，都要实现正确的equals（）和hashCode（）方法，实际上HashSet仅仅是对HashMap的一个简单封装

```java
public class HashSet<E> implements Set<E> {
    // 持有一个HashMap:
    private HashMap<E, Object> map = new HashMap<>();

    // 放入HashMap的value:
    private static final Object PRESENT = new Object();

    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }

    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    public boolean remove(Object o) {
        return map.remove(o) == PRESENT;
    }
}
```

手写ArrList扩容可用

```
System.arraycopy(arr,0,newArr,0,arr.length);
```

System.arraycopy（数组，开始位置，目标数字，开始位置，复制长度）

