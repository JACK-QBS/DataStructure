package 线性表;

public class linkedListIterator implements Iterator{

    private linkedList list;
    private Node cur;

    public linkedListIterator(linkedList list) {
        this.list = list;
        this.cur = list.head;
    }

    @Override
    public boolean hasNext() {
        return cur != null;
    }

    @Override
    public Integer next() {
        Integer e = cur.element;
        cur = cur.next;
        return e;
    }
}
