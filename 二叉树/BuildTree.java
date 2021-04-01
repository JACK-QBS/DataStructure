package Tree;

public class BuildTree {
    public static TreeNode buildTree1(){
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

        return a;
    }
}
