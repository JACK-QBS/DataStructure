
class Node{
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

public class First {
    public static Node reverse(Node head) {
        Node prev = null;
        while (head != null) {
            Node headNext = head.next;
            head.next = prev;
            prev = head;
            head = headNext;
        }
        return prev;
    }
    public static void main(String[] args) {
        // 构造一个 1 2 3 4 的链表
        // 4 个对象、 5 个引用
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        // 逆置链表
        Node reverseHead = reverse(head);
        Node cur = reverseHead;
        while (cur != null) {
            System.out.print(cur.val);
            cur = cur.next;
        }

    }
}
