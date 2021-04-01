package Tree;

//计算一个二叉树中叶子结点的个数
public class SomeMethod3 {

    private static int count;//计算叶子结点的个数

    public static int sumTreeLeafNodeSize(TreeNode root) {
        count = 0;
        preOrder(root);
        return count;
    }

    //第一种方式：前序遍历二叉树
    private static void preOrder(TreeNode root) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                count++;
            }
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    //第二种方式：
    private static int sumTreeLeafNodeSize2(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null){
            return 1;
        } else {
            int leftSubTreeNodeSize = sumTreeLeafNodeSize2(root.left);//左子树的叶子结点个数
            int rightSubTreeNodeSize = sumTreeLeafNodeSize2(root.right);//右子树的叶子结点个数

            return leftSubTreeNodeSize + rightSubTreeNodeSize;
        }
    }

    public static void main(String[] args) {
        TreeNode root = BuildTree.buildTree1();
        int num1 = sumTreeLeafNodeSize(root);
        System.out.println("二叉树中叶子结点为："+num1);

        int num2 = sumTreeLeafNodeSize(root);
        System.out.println("二叉树中叶子结点为："+num2);
    }
}
