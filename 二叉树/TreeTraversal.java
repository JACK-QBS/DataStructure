package Tree;

// 遍历树
public class TreeTraversal {
    // 对 root 尾根的树进行遍历
    // 遍历的对象是树，不是结点
    // 虽然我们的形参看起来是结点，但实际上是以该结点尾根的树
    // 为了简单，我们只进行结点的值的打印

    // 前序遍历
    public static void preTraversal(TreeNode root) {
        // 前提：这颗树不是空树（根结点存在）
        if (root != null) {
            // 1、首先处理根结点
            System.out.printf("%c",root.v);
            // 2、按照前序的方式，递归处理该结点的左子树
            preTraversal(root.left);
            // 3、按照前序的方式，递归处理该结点的右子树
            preTraversal(root.right);
        } else {
            // 什么都不干
        }
    }

    // 中序遍历
    public static void inTraversal(TreeNode root) {
        if (root != null) {
            // 1、中序遍历左子树
            inTraversal(root.left);
            // 2、处理根
            System.out.printf("%c",root.v);
            // 3、中序遍历右子树
            inTraversal(root.right);
        }
    }

    // 后序遍历
    public static void postTraversal(TreeNode root) {
        if (root != null) {
            // 1、后续遍历左子树
            postTraversal(root.left);
            // 2、后续遍历右子树
            postTraversal(root.right);
            // 3、处理根
            System.out.printf("%c",root.v);

        }
    }

    public static void main(String[] args) {
        // 先构造结点
        TreeNode a = new TreeNode('A');
        TreeNode b = new TreeNode('B');
        TreeNode c = new TreeNode('C');
        TreeNode d = new TreeNode('D');
        TreeNode e = new TreeNode('E');
        TreeNode f = new TreeNode('F');
        TreeNode g = new TreeNode('G');
        TreeNode h = new TreeNode('H');
        TreeNode i = new TreeNode('I');
        TreeNode j = new TreeNode('J');

        // 连接结点
        a.left = b;
        a.right = c;

        b.left = d;

        c.left = e;
        c.right = f;

        d.right = g;

        f.left = h;
        f.right = i;

        g.left = j;

        System.out.println("前序遍历： ");
        preTraversal(a);
        System.out.println();

        System.out.println("中序遍历： ");
        inTraversal(a);
        System.out.println();

        System.out.println("后序遍历： ");
        postTraversal(a);
        System.out.println();

    }


}
