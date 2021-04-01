package Tree;

//计算二叉树中结点个数2
public class SomeMethod2 {

    // 根的个数 + 左子树的结点个数 + 右子树结点个数
    public static int sumTreeNodeSize2(TreeNode root) {

        if (root == null) {
            //该二叉树是一个空树
            return 0;
        } else {
            int rootNodeSize = 1; //根结点的个数
            int leftSubTreeNodeSize = sumTreeNodeSize2(root.left);//左子树结点个数
            int rightSubTreeNodeSize = sumTreeNodeSize2(root.right);//右子树结点个数
            return rootNodeSize + leftSubTreeNodeSize + rightSubTreeNodeSize;
        }
    }

    public static void main(String[] args) {
        TreeNode root = BuildTree.buildTree1();
        int sum = sumTreeNodeSize2(root);
        System.out.println("二叉树中结点的个数是："+sum);

    }
}
