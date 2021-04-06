package Tree;

public class Heap {
    public static void adjustDown(int[] array,int size,int index) {
        while (true) {
            //1、判断 Index 是不是叶子
            int leftIndex = 2 * index + 1;
            if (leftIndex >= size) {
                //index 是叶子
                return;
            }
            // 2、找出最小的孩子
            int minIndex = leftIndex;
            int rightIndex = leftIndex + 1;
            if (rightIndex < size && array[rightIndex] < array[leftIndex]) {
                minIndex = rightIndex;
            }
            //3、比较最小孩子的值 和 index位置的值
            if (array[index] < array[minIndex]) {
                return;
            }
            //4、交换
            int t = array[index];
            array[index] = array[minIndex];
            array[minIndex] = t;
            //5、把最小孩子视为 Index，循环回去
            index = minIndex;
        }
    }

    public static void creatHeap(int[] array,int size) {
        // 找到层序遍历的最后一个结点下标
        int lastIndex = size - 1;
        // 找到最后一个结点的父节点的下标
        int lastParentIndex = (lastIndex - 1) / 2;
        // 从[lastParentIndex,0] 不断向下调整
        for (int i = lastParentIndex; i >= 0; i--) {
            adjustDown(array,size,i);
        }
    }
}
