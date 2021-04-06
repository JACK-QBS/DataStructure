package Tree;

//实现一个优先队列
public class MyPriorityQueue {
    private Integer[] array;
    private int size;

    public MyPriorityQueue() {
        array = new Integer[100];
        size = 0;
    }

    public Integer element() {
        if (size == 0) {
            throw new RuntimeException("空的");
        }
        return array[0];
    }

    public Integer remove() {
        if (size == 0) {
            throw new RuntimeException("空了");
        }
        int e = array[0];
        array[0] = array[size - 1];
        size--;
        adjustDown(0);
        return e;
    }

    private void adjustDown(int index) {
        while (true) {
            //判断 index 位置有无孩子
            int leftIndex = 2 * index + 1;//index位置的左孩子的位置
            if (leftIndex >= size) {
                return;
            }
            // 有左右孩子，找出最小的孩子
            int minIndex = leftIndex;
            int rightIndex = 2 * index + 2;
            if (rightIndex < size && array[rightIndex] < array[leftIndex]) {
                minIndex = rightIndex;
            }
            // 比较 index位置的值 和 最小孩子的值
            if (array[index] < array[minIndex]) {
                return;
            }
            int e = array[index];
            array[index] = array[minIndex];
            array[minIndex] = e;
            // 把最小的孩子作为 index ，循环
            index = minIndex;
        }

    }
}
