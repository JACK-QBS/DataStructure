package MyHashTable;

//元素类型，使用Integer
//使用拉链法解决冲突
public class MyHashTable {
    //1、数组：
    private Node[] array = new Node[11];
    //2、维护哈希表中的元素个数
    private int size;
    //true：key 之前不在哈希表中
    //false：key 之前已经在哈希表
    public boolean insert(Integer key) {
        //1、把对象转成 int 类型
        int hashValue = key.hashCode();
        //2、把 hashValue 转成合法下标
        int index = hashValue % array.length;
        //3、遍历 index 位置的链表，确定 key 在不在元素中
        Node cur = array[index];
        while (cur != null) {
            if (key.equals(cur.key)) {
                return false;
            }
            cur = cur.next;
        }
        //4、把 key 装入结点中，对插入到对应的链表中
        Node node = new Node(key);
        node.next = array[index];
        array[index] = node;
        //5、维护元素个数
        size++;
        return true;
    }

    public boolean remove(Integer key) {
        int hashValue = key.hashCode();
        int index = hashValue % array.length;
        Node cur = array[index];//要删除的当前结点
        //删除第一个结点
        if (key.equals(cur.key)) {
            cur.next = null;
            return true;
        }
        Node prev = null;//要删除的结点的前一个结点
        while (cur != null) {
            if (key.equals(cur.key)) {
                if (cur.next != null) {
                    //删除中间结点
                    prev.next = cur.next;
                } else {
                    //删除最后一个结点
                    prev.next = null;
                }
                size--;
                return true;
            }
            prev = cur;
            cur = cur.next;
        }
        //没找到要删除的元素
        return false;
    }

    public boolean contains(Integer key) {
        //找到对应的下标
        int hashValue = key.hashCode();
        int index = hashValue % array.length;
        Node cur = array[index];
        while (cur != null) {
            if (key.equals(cur.key)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
}
