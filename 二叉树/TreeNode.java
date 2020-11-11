package Tree;

public class TreeNode {
    int v;
    TreeNode left; // 左子树
    TreeNode right; // 右子树

    public TreeNode(int v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return String.format("%c",v);
    }
}
