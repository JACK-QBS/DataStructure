package Tree;

public class Heap1 {
    //向上调整
    public static void adjustUp(int[] array,int size,int index) {
        while (true){
            //1、判断 index 是不是树的根，如果是根调整结束
            if (index == 0) {
                break;
            }
            //2、找到 index 的父节点
            int parentIndex = (index - 1) / 2;
            //3、比较 index 和 父节点的值
            //4、只要父节点的值 < index的值，调整结束
            if (array[parentIndex] < array[index]) {
                break;
            }
            //5、交换父节点 和 index 位置的值
            int t = array[parentIndex];
            array[parentIndex] = array[index];
            array[index] = t;
            //6、把父节点看出index的，继续这个大循环
            index = parentIndex;
        }

    }
}
