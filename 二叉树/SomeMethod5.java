package Tree;

/**
 * 汇集的思路：
 * 1、传入的参数是树，而不应该看作结点
 * 2、分情况讨论（空树 / 一个结点的树 / 其他）
 * 3、一般把二叉树分为三个部分：根节点 + 左子树 + 右子树
 * 把整棵树的求解问题 -> 左子树 / 右子树 + 根汇集
 *
 * 一般用于解决 ： 结点个数 / 叶子结点个数 / 第 k 层结点个数 / 求高度 / 查找
 */
public class SomeMethod5 {

    //计算树的高度
    private static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else {
            int leftSubTreeHeight = getHeight(root.left);//左子树的高度
            int rightSubTreeHeight = getHeight(root.right);//右子树的高度
            return Math.max(leftSubTreeHeight,rightSubTreeHeight) + 1;
        }
    }

    //判断二叉树中是否包含某个数（s）
    private static boolean contains(TreeNode root,int s) {
        if (root == null) {
            //空树
            return false;
        } else {
            if (root.v == s) {
                //根节点处找到
                return true;
            } else {
                boolean leftSubTreeContains = contains(root.left,s);
                if (leftSubTreeContains) {
                    //左子树中找到
                    return true;
                } else {
                    boolean rightSubTreeContains = contains(root.right,s);
                    if (rightSubTreeContains) {
                        //右子树中找到
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
    }
    //contains 方法的简写
    private static boolean contains2(TreeNode root,int s) {
        if (root == null) {
            //空树
            return false;
        }
        //根节点处找到
        if (root.v == s) {
            return true;
        }
        //左子树中找到
        boolean left = contains2(root.left,s);
        if (left) {
            return true;
        }
        //右子树中找找到
        return contains2(root.right,s);
    }

    //找到二叉树中的某个结点，并返回该结点（s）
    private static TreeNode contains3(TreeNode root,int s) {
        if (root == null) {
            //空树
            return null;
        }
        if (root.v == s) {
            return root;
        }
        TreeNode left = contains3(root.left,s);
        if (left != null) {
            return left;
        }
        return contains3(root.right,s);
    }



    public static void main(String[] args) {
        TreeNode root = BuildTree.buildTree1();

        /*System.out.println("二叉树的高度是：" + getHeight(root));

        System.out.println("二叉树中包含该元素"+ contains(root,'B'));
        System.out.println("二叉树中包含该元素"+ contains2(root,'B'));*/

        System.out.println("二叉树中该元素为：" + contains3(root,'B'));
    }
}
