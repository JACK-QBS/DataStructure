package Tree;

import java.util.LinkedList;
import java.util.Queue;

//带层级的层次遍历
public class TreeLevelOrder1 {
    //用来打包层次和结点
    static class NL{
        TreeNode node;
        int level;
        NL(TreeNode node,int level) {
            this.node = node;
            this.level = level;
        }
    }

    public static void levelOrderWithLevel(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<NL> queue = new LinkedList<>();
        queue.add(new NL(root,1));
        while (!queue.isEmpty()) {
            NL nl = queue.remove();
            TreeNode node = nl.node;
            int level = nl.level;
            System.out.print(level);
            System.out.println(node);

            if (root.left != null) {
                queue.add(new NL(node.left,level+1));
            }
            if (root.right != null) {
                queue.add(new NL(node.right,level+1));
            }
        }

    }
}
