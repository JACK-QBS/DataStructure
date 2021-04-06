package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class treeTest {
    //二叉树求高度
    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else {
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);
            return 1 + Math.max(leftHeight,rightHeight);
        }
    }

    //层序遍历
    public static void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            System.out.println("该二叉树为空");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode n = queue.remove();
            System.out.println(n.v);
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
        }
    }
}
