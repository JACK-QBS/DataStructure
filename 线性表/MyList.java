package 线性表;


/**
 * int 用在下标
 * Integer 表示元素
 */
// 仿写真实的 (java.util.List) MyList 接口

public interface MyList extends Iterable{
    boolean add(Integer e); // 尾插
    void add(int index,Integer e); // 把 e 插到 index 所在位置后

    Integer remove (int index); // 根据下标删除
    boolean remove (Integer e); // 删除第一个遇到的

    Integer get(int index); // 返回 index 位置处的元素
    Integer set(int index,Integer e); //用 e 替换 index位置上的元素

    int size(); // 元素个数
    void clear(); // 清空线性表
    boolean isEmpty(); // 返回是否是一个空的线性表

    boolean contains(Integer e); // 线性表中是否包含 e 这个对象
    int indexOf(Integer e); // 返回第一个遇到 e 这个对象的下标
    int lastIndexOf(Integer e); // 返回最后一个遇到 e 这个对象的下标
}

// 迭代器
interface Iterator {
    boolean hasNext();
    Integer next();
    void remove();
}

// 具备迭代能力,使用迭代器
// 可以返回迭代器，就说明具备迭代能力
interface Iterable {
    Iterator iterator();
}