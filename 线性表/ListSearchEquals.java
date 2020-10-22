package 线性表;

import java.util.ArrayList;
import java.util.*;

public class ListSearchEquals {
    static class Person {
        int id;
        String name;
        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return id == person.id &&
                    Objects.equals(name, person.name);
        }
    }

    public static void main(String[] args) {
        Person p1 = new Person(1,"乔邦朔");
        Person p2 = new Person(1,"马乐");
        List<Person> list = new ArrayList<>();
        list.add(p1);
        System.out.println(list.contains(p2));
        System.out.println(list.indexOf(p2)); // 返回给定元素第一次在链表中的位置

        List<Character> list2 = new ArrayList<>();
        list2.add('A');
        list2.add('B');
        list2.add('C');
        list2.add('D');
        list2.add('E');
        list2.add('F');
        System.out.println(list2);
        List<Character> subList = list2.subList(1,4); // 取 [1,4) 之间的元素(截取)
        System.out.println(subList);
        System.out.println(list2);

        List<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(4);
        list3.add(9);
        list3.add(10);
        list3.add(1);
        System.out.println(list3);
        // 对线性表进行排序，以传入的比较器进行元素的比较
        list3.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2; // 从小到大排
            }
        });
        System.out.println(list3);
        list3.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1; // 从大到小排
            }
        });
        System.out.println(list3);

        List<String> list4 = new ArrayList<>();
        list4.add("A");
        list4.add("B");
        list4.add("C");
        list4.add("C");
        list4.add("E");
        list4.add("F");
        Iterator<String> it = list4.iterator();
        while(it.hasNext()) {
            // hasNext()被调用6次   next()被调用5次
            String next = it.next();
            System.out.println(next);
        }
        // 上述写法，可以被 foreach 写法替代
        // foreach 写法，本质上，其实就是通过迭代器实现的
        for (String next : list4) {
            System.out.println(next);
        }
        // 使用迭代器删除当前迭代到的元素
        Iterator<String> it1= list4.iterator();
        while(it1.hasNext()) {
            String next = it1.next();
            if(next.equals("C")) {
                it1.remove(); // 删除当前迭代到的元素
            }
        }
        System.out.println(list);
        // 从后往前遍历
        ListIterator<String> it4 = list4.listIterator(list4.size());
        while(it4.hasPrevious()) {
            String previous = it4.previous();
            System.out.println(previous);
        }

    }
}

