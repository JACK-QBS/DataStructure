package 队列;

import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();

        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(4);
        deque.add(5);
        deque.add(6);

        System.out.println(deque.removeLast()); // 6
        System.out.println(deque.removeLast()); // 5
        System.out.println(deque.removeFirst()); // 1
        System.out.println(deque);

        /*deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addFirst(4);
        deque.addLast(5);
        deque.addLast(6);
        deque.addLast(7);

        while (!deque.isEmpty()) {
            if (!deque.isEmpty()) {
                // 第一个元素是多少
                System.out.println(deque.getFirst());
            }
            if (!deque.isEmpty()) {
                // 取出第一个元素
                System.out.println(deque.remove());
            }
            if (!deque.isEmpty()) {
                // 最后一个元素是多少
                System.out.println(deque.getLast());
            }
            if (!deque.isEmpty()) {
                // 取出最后一个元素
                System.out.println(deque.removeLast());
            }
        }*/
    }
}
