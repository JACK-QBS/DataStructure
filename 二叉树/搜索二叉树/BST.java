package binary_search_tree;

//搜索二叉树
public class BST {
    private Node root;
    public BST() {
        //构建一颗空树
        root = null;
    }

    //查找
    public boolean search(Integer key) {
        Node cur = root;
        while (cur != null) {
            int cmp = key.compareTo(cur.key);
            if (cmp == 0) {
                return true;
            } else if (cmp < 0) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return false;
    }

    //插入
    public void insert(Integer key){
        //空树
        if (root == null) {
            root = new Node(key);
            return;
        }
        //始终保持 parent 是 cur 的双亲节点
        Node parent = null;
        Node cur = root;
        int cmp = 0;
        while (cur != null) {
            cmp = key.compareTo(cur.key);
            if (cmp == 0) {
                //说明二叉树中已经有该节点，直接抛异常
                throw new RuntimeException("BST 中不允许出现两个相同的数");
            } else if (cmp < 0) {
                parent = cur;
                cur = cur.left;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }
        //cur 已经到了要插入的位置了
        Node newNode = new Node(key);
        if (cmp < 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }

    //删除
    public boolean remove(Integer key) {
        Node cur = root;//要删除的节点
        Node parent = null;//cur 的双亲节点
        //找到要删除的元素
        while (cur != null) {
            int cmp = key.compareTo(cur.key);
            if (cmp == 0) {
                removeInternal(cur,parent);
                return true;
            } else if (cmp < 0) {
                parent = cur;
                cur = cur.left;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }
        //没找到要删除的元素
        return false;
    }

    private void removeInternal(Node cur, Node parent) {
        //1、要删除的结点是 叶子结点
        if (cur.left == null && cur.right == null) {
            if (cur == root) {
                root = null;
            } else if (cur == parent.left){
                //要删除的结点是其父节点的左孩子
                parent.left = null;
            } else {
                //要删除的结点是其父节点的右孩子
                parent.right = null;
            }
        } else if (cur.left != null && cur.right == null) {
            //2、要删除的结点只有 左孩子
            if (cur == root) {
                root = cur.left;
            } else if (cur == parent.left){
                //要删除的结点是其父节点的左孩子,让他自己的左孩子代替他的位置
                parent.left = cur.left;
            } else {
                //要删除的结点是其父节点的右孩子,让他自己的左孩子代替他的位置
                parent.right = cur.left;
            }
        } else if (cur.left == null && cur.right != null) {
            //3、要删除的结点只有 右孩子
            if (cur == root) {
                root = cur.right;
            } else if (cur == parent.left){
                //要删除的结点是其父节点的左孩子,让他自己的左孩子代替他的位置
                parent.left = cur.right;
            } else {
                //要删除的结点是其父节点的右孩子,让他自己的左孩子代替他的位置
                parent.right = cur.right;
            }
        } else {
            //4、要删除的结点，左右孩子都有（采用替换法删除）
            //使用 cur 的左子树中的做大值所在的结点，记作 ghost，ghost 的双亲记作 ghostParent
            Node ghost = cur.left;
            Node ghostParent = null;
            //一路向右查找，直到 ghost.right == null
            if (ghost.right != null) {
                ghostParent = ghost;
                ghost = ghost.right;
            }
            //（1）替换
            cur.key = ghost.key;
            //（2）删除 ghost 结点（其右孩子一定为空）
            if (cur == ghostParent) {
                ghostParent.left = ghost.left;
            } else {
                ghostParent.right = ghost.left;
            }
        }
    }
}
