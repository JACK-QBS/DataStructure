package Tree;

//计算二叉树中结点个数
public class SomeMethod {

    private static int count;

    public static int sumTreeNodeSize(TreeNode root) {
        //每次数之前先把 count 置零
        count = 0;
        preOrder(root);
        return count;
    }

    //前序遍历
    private static void preOrder(TreeNode root) {
        if (root != null) {
            //处理根的时候，让计数++
            count++;
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = BuildTree.buildTree1();
        int sum = sumTreeNodeSize(root);
        System.out.println("二叉树中结点的个数是："+sum);

    }
}
