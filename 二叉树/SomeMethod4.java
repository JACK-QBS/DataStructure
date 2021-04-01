package Tree;

//计算一个二叉树第 K 层结点的个数
public class SomeMethod4 {

    private static int sumKLevelNodeSize(TreeNode root,int k) {
        if (root == null) {
            //root 为空树
            return 0;
        } else if (k == 1){
            //返回根结点
            return 1;
        } else {
            int leftSubTreeK_1 = sumKLevelNodeSize(root.left,k -1);//左子树中第 K-1 层系结点个数
            int rightSubTreeK_1 = sumKLevelNodeSize(root.right,k -1);//右子树中第 K-1 层系结点个数
            return leftSubTreeK_1 + rightSubTreeK_1;
        }
    }

    public static void main(String[] args) {
        TreeNode root = BuildTree.buildTree1();

        System.out.println("二叉树第 1 层结点为："+sumKLevelNodeSize(root,1));
        System.out.println("二叉树第 2 层结点为："+sumKLevelNodeSize(root,2));
        System.out.println("二叉树第 3 层结点为："+sumKLevelNodeSize(root,3));
        System.out.println("二叉树第 4 层结点为："+sumKLevelNodeSize(root,4));
        System.out.println("二叉树第 5 层结点为："+sumKLevelNodeSize(root,5));

    }
}
