package List;

public class ListReverse {
    //逆序链表
    public static Node reverse(Node head) {
        Node cur = head;//当前节点
        Node prev = null;//当前节点的前一个节点
        Node temp = null;//代表反转后链表的头节点
        while (cur != null) {
            if (cur.next == null) {
                temp = cur;
            }
            Node curNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return temp;
    }

    public static void main(String[] args) {
        //构造一个 1 2 3 4 的链表
        Node head = new Node();

        //逆置链表
        Node reverseHead = reverse(head);

        //打印链表

    }

}
