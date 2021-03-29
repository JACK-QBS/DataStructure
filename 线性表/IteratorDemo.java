package List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        /*Iterator<String> it = list.iterator();
        while (it.hasNext()) { // hasNext 被调用6次
            String next = it.next(); // next 被调用5次
            System.out.println(next);
        }*/

        //多个迭代器之间互相独立
        /*Iterator<String> it1 = list.iterator();
        Iterator<String> it2 = list.iterator();
        it1.next();it1.next();
        System.out.println(it1.next());
        System.out.println(it2.next());*/


        // 删除元素(错误的)循环删除(报错)
        // 链表在循环遍历的时候不允许改变表的结构
        /*for (String next : list) {
            if (next.equals("C")) {
                list.remove("C");
            }
        }*/
        //删除元素（正确的）使用迭代的方式删除
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next.equals("C")) {
                it.remove();//删除当前迭代到的元素
            }
        }
        System.out.println(list);

    }
}
