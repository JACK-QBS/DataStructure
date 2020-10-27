package 线性表;

import java.util.*;
import java.util.Iterator;

/**
 * 泛型的 ArrayList ：
 * 1、clear 或者 其他删除的时候，除了要修改 size ，一定要把从 List 中删除掉的元素置为 null ，以免内存泄漏
 * 2、contains/indexOf/lastIndexOf 等方法时，都随时可能调用元素的 equals 方法
 * 3、toArray 的两种实现
 *
 */

public class GenericityArrayList<E> implements List<E> {

    private E[] array;
    private int size;

    public GenericityArrayList() {
        // 无法直接定义泛型数组，所以只能定义 Object 类型的数组
        // 然后强转
        array = (E[])new Object[10];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] a = new Object[size];
        for (int i = 0; i < size; i++) {
            a[i] = array[i];
        }
        return a;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            // 创建一个数组直接返回
            T[] newArray = (T[])new Object[size];
            for (int i = 0; i < size; i++) {
                newArray[i] = (T) array[i];
            }
            return newArray;
        } else if (a.length == size) {
            // 把元素放入并返回
            for (int i = 0; i < size; i++) {
                a[i] = (T) array[i];
            }
            return a;
        } else {
            // 把元素放入并返回
            // 把超过的第一个位置设为 null
            for (int i = 0; i < size; i++) {
                a[i] = (T) array[i];
            }
            a[size] = null;
            return a;
        }
    }

    @Override
    public boolean add(E e) {
        array[size++] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int i = indexOf(o);
        if (i == -1) {
            return false;
        } else {
            remove(i);
            return true;
        }
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        return false;
    }

    @Override
    public boolean addAll(int i, Collection<? extends E> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {
        // 如果是基本类型，数组中的元素是否要清理成无效值无所谓
        // 但如果是引用类型，必须把数组中的元素修改成 Null
        // 这样才不会内存泄漏
        Arrays.fill(array,null);
        size = 0;
    }

    @Override
    public E get(int i) {
        return array[i];
    }

    @Override
    public E set(int i, E e) {
        E element = array[i];
        array[i] = e;
        return element;
    }

    @Override
    public void add(int i, E e) {

    }

    @Override
    public E remove(int i) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (o == null) {
                if (array[i] == o) {
                    return i;
                }
            } else {
                if (o.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int i) {
        return null;
    }

    @Override
    public List<E> subList(int i, int i1) {
        return null;
    }
}
