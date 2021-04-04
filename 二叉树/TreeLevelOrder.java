package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeLevelOrder {
    //层序遍历
    public static void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        //队列的元素的类型是树的结点
        Queue<TreeNode> queue = new LinkedList<>();
        //1、把根节点放入队列
        queue.add(root);
        //2、开启循环
        while (!queue.isEmpty()) {
            //（1）从队列中取出队首元素
            //node 就是层序遍历时经过的结点
            TreeNode node = queue.remove();
            //（2）打印遍历结点的值
            System.out.println(node.v);
            //（3）把该结点的左右子树放入队列中
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    //判断二叉树是否为完全二叉树
    public static boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (true) {
            TreeNode node = queue.remove();
            if (node == null) {
                break;
            }
            queue.add(node.left);
            queue.add(node.right);
        }
        //后序的结点全为 null 才是完全二叉树
        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node == null) {

            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = BuildTree.buildTree1();
        levelOrderTraversal(root);
    }
}
