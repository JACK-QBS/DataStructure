package 线性表;

/**
 *  实现一个自己的顺序表
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyArrayList implements MyList{
    private int[] array; // 顺序表内部的数组
    private int size; // 顺序表内部元素的个数

    @Override
    public String toString() {
        return "MyArrayList{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                '}';
    }

    public MyArrayList() {
        // 初始容量是10个
        array = new int[10];
        // 初始的元素个数是0个
        size = 0;
    }
    /*public MyArrayList(MyList other) {

    }*/

    // 扩容
    public void ensureCapacity(int capacity) {
        // 1、检查是否需要扩容
        if (array.length >= capacity) {
            return;
        }
        // 2、定义新的数组
        int[] newArray = new int[capacity];
        // 3、进行搬家，从 array 数组搬到 newArray 数组中
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        // 4、不在关联 array ， 关联新的 newArray
        this.array = newArray;
    }

    @Override
    public boolean add(Integer e) {
        if (array.length == size) {
            ensureCapacity(array.length*2);
        }
        array[size++] = e;
        return true;
    }


    @Override
    public void add(int index, Integer e) {
        if (array.length == size) {
            ensureCapacity(array.length*2);
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("不合法小标"+size);
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i-1];
        }
        array[index] = e;
        size++;
    }

    @Override
    public Integer remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("不合法小标"+size);
        }
        // 从前往后删
        int e = array[index]; // 记录一下起始位置
        for (int i = index; i < size-1; i++) {
            array[i] = array[i+1];
        }
        size--;
        return e;
    }

    @Override
    public boolean remove(Integer e) {
        /*for (int i = 0; i < size; i++) {
            if (array[i] == e) {
                remove(i);
                return true;
            }
        }
        return false;*/

        int index = indexOf(e);
        if (index != -1) {
            remove(index);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Integer get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("不合法小标"+size);
        }
        return indexOf(index);
    }

    @Override
    public Integer set(int index, Integer e) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("不合法小标"+size);
        }
        Integer old = array[index];
        array[index] = e;
        return old;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        // -1 暂时代表无效值
        Arrays.fill(array,-1);
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
        for (int i = 0; i < size; i++) {
            if (array[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer e) {
        for (int i = size - 1; i > 0; i--) {
            if (array[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MyList list = new MyArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        System.out.println(list.size());

        list.add(0,100);
        System.out.println(list);
        System.out.println(list.size());

        try {
            list.add(-1,100);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }

        list.remove(3);
        System.out.println(list);
        System.out.println(list.size());


    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
