package MapUse;

public class TreeNode {
    String key;
    Integer value;
    TreeNode left;
    TreeNode right;

    TreeNode(String key,Integer value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "key='" + key + '\'' +
                ", value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
