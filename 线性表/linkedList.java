package 线性表;


class Node {
    public Node prev;
    public Node next;
    public Integer element;

    public Node(Integer element) {
        this.element = element;
    }

}

public class linkedList implements MyList{

    public Node head; // 头节点
    public Node last; // 尾节点
    public int size;

    @Override
    public boolean add(Integer e) {
        Node newNode = new Node(e);
        // 链表中没有节点
        if (head == null) {
            this.head = this.last = newNode;
        } else {
            this.last.next = newNode;
            newNode.prev = this.last;
            this.last = newNode;
        }
        this.size++;
        return true;
    }

    @Override
    public void add(int index, Integer e) {

        Node newNode = new Node(e); // 把值装入结点中
        Node cur;

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("下标越界： "+ index);
        }
        if (index == size) {
            // 尾插
            add(e);
        }
        if (index == 0) {
            // 头插
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
            size++;
        } else {
            // 中间插
            // 从 head 处出发，找到 index -1 位置的结点
            if(index - 1 < size / 2) {
                // 从 head 处出发，找到 index -1 位置的结点
                cur = head;
                for (int i = 0; i < index - 1; i++) {
                    cur = cur.next;
                }
            } else {
                // 从 last 处出发，找到 index -1 位置的结点
                cur = last;
                for (int i = 0; i < size - index; i++) {
                    cur = cur.prev;
                }
            }
            // 走到这时，cur 指向 index -1 位置的下标
            Node curNext = cur.next;

            newNode.prev = cur;
            newNode.next = curNext;
            curNext.prev = newNode;
            cur.next = newNode;
            size++;
        }
    }

    @Override
    public Integer remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("下标越界： "+ index);
        }
        Integer v;
        if (index == 0) {
            // 头删
            v = head.element;
            this.head = this.head.next;
            this.head.prev = null;
            size--;
            if (size == 0) {
                last = null;
            }
        } else if (index == size - 1) {
            // 尾删
            v = last.element;
            this.last = this.last.prev;
            this.last.prev = null;
            size--;
            if (size == 0) {
                head = null;
            }
        } else {
            Node cur;
            if(index - 1 < size / 2) {
                // 从 head 处出发，找到 index -1 位置的结点
                cur = head;
                for (int i = 0; i < index - 1; i++) {
                    cur = cur.next;
                }
            } else {
                // 从 last 处出发，找到 index -1 位置的结点
                cur = last;
                for (int i = 0; i < size - index; i++) {
                    cur = cur.prev;
                }
            }
            Node toRemove = cur.next;
            v = toRemove.element;
            cur.next = toRemove.next;
            toRemove.next.prev = cur;
            size--;
        }
        return v;
    }

    @Override
    public boolean remove(Integer e) {
        Node prev = null;
        for (Node cur = head; cur != null; prev = cur,cur = cur.next) {
            if (cur.equals(e)) {
                if (prev == null) {
                    remove(0);
                    return true;
                } else {
                    prev.next.next.prev = prev;
                    prev.next = prev.next.next;
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Integer get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("下标越界： "+ index);
        }
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.element;
    }

    @Override
    public Integer set(int index, Integer e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("下标越界： "+ index);
        }
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        Integer v = cur.element;
        cur.element = e;
        return v;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        last = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Integer e) {
        return indexOf(e) != -1;
    }

    @Override
    public int indexOf(Integer e) {
        int i = 0;
        for (Node cur = head; cur != null; cur = cur.next, i++) {
            if (cur.element.equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer e) {
        int i = 0;
        for (Node cur = last; cur != null; cur = cur.prev, i++) {
            if (cur.element.equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator iterator() {
        return new linkedListIterator(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (Node cur = head; cur != null; cur = cur.next) {
            sb.append(cur.element);
            if (cur != last) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        MyList list = new linkedList();
        list.add(31);
        list.add(32);
        list.add(33);
        list.add(1,1);
        System.out.println(list);

        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }
}
