package Tree;

import java.util.Deque;
import java.util.LinkedList;

public class Non {
    public static void preOrder(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            //遍历左子树
            while (cur != null) {
                System.out.println(cur.v);
                stack.push(cur);
                cur = cur.left;
            }
            //取出栈顶元素
            TreeNode top = stack.pop();
            //遍历右子树
            cur = top.right;
        }
    }

    public static void inOrder(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            //遍历左子树
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //取出栈顶元素
            TreeNode top = stack.pop();
            //回来的时候打印他
            System.out.println(top.v);
            //遍历右子树
            cur = top.right;
        }
    }

    public static void postOrder(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        TreeNode last = null;//记录上次遍历的结点
        while (!stack.isEmpty() || cur != null) {
            //遍历左子树
            while (cur != null) {
                //第一次经过 cur 这个结点
                stack.push(cur);
                cur = cur.left;
            }
            //取出栈顶元素但不删除
            TreeNode top = stack.peek();
            if(top.right == null) {
                //第二次经过 top 这个结点（因为右边为空，所以可以看作第三次）
                //从左子树中回来，但是右子树为空，可以看作从右子树回来
                stack.pop();
                last = top;
                System.out.println(top.v);
            } else if (top.right == last){
                //第三次经过 top
                //说明从右子树中回来的
                stack.pop();
                last = top;
                System.out.println(top.v);
            } else {
                //第二次经过 top
                //说明从左子树中回来的
                cur = top.right;
            }
        }
    }

}
