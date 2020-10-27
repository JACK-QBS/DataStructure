package 线性表;

public class MyArrayListIterator implements Iterator {
    // 对一个顺序表做迭代，关键是 控制下标

    private MyArrayList list; // 我们要迭代（遍历）的顺序表
    private int index; // 我们在顺序表的位置

    public MyArrayListIterator(MyArrayList list) {
        this.list = list;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    /**
     * 1、返回迭代器当前所在的位置的元素
     * 2、让迭代器走到下一个位置
     */
    @Override
    public Integer next() {
        return list.get(index++);
    }

    @Override
    public void remove() {

    }
}
