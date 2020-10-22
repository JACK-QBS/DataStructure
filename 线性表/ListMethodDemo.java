package 线性表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 线性表
 */
public class ListMethodDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello"); // 尾插 到线性表
        list.add("world");
        list.add("I'am ");
        list.add("cool");
        list.add(2,"吃了没"); // 在 2 位置插入

        System.out.println(list);
        String s = list.get(2); // 返回 2 下标处的元素
        System.out.println(s);
        list.set(4,"好的"); // 用 “好的” 替换4位置的元素
        System.out.println(list.size()); // 元素个数

        /*System.out.println(list.isEmpty()); // 判断 size 是否为 0（返回是否是一个空的线性表）
        list.clear(); // 清空线性表
        System.out.println(list.isEmpty());
        System.out.println(list.size());*/

        System.out.println(list.contains("hello")); // 判断 线性表表中是否包含给定元素
        System.out.println(list.contains("帅哥"));
        System.out.println(list.indexOf("cool")); // 返回给定元素第一次在链表中的位置
        System.out.println(list.lastIndexOf("cool")); // 返回给定元素最后一次在链表中的位置
        System.out.println(list.indexOf("帅哥"));

        // 线性表 转 数组
        List<String> list4 = new ArrayList<>();
        list4.add("A");
        list4.add("B");
        list4.add("C");
        list4.add("C");
        list4.add("E");
        list4.add("F");
        Object[] objects = list4.toArray();
        for(Object o : objects) {
            String s2 = (String)o;
            // 大写 转 小写
            System.out.println(s.toLowerCase());
        }
        String[] sArray = new String[5];
        String[] strings = list4.toArray(sArray);
        System.out.println(Arrays.toString(strings));

        // 数组 转 线性表
        String[] array = {"You","are","cool"};
        List<String> strings4 = Arrays.asList(array);
        System.out.println(strings4);
        System.out.println(strings4.getClass());
    }
}

