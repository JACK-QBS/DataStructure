package Tree;

class Node {
    int val;
    Node next;
    Node(int val) {
        this.val = val;
    }
}
public class test {
    //头插
    public static Node headAdd(Node head,int e) {
        Node newHead = new Node(e);
        if (head == null) {
            head = newHead;
            return head;
        }
        newHead.next = head;
        head = newHead;
        return head;
    }

    //尾插
    public static Node lastAdd(Node head,int e) {
        Node newHead = new Node(e);
        if (head == null) {
            head = newHead;
            return head;
        }
        Node cur = head;//遍历链表
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newHead;
        return newHead;
    }

    //头删
    public static void headRemove(Node head) {
        if (head == null) {
            return;
        }
        head.next = null;
    }

    //尾删
    public static void lastRemove(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        cur.next = null;
    }

}
