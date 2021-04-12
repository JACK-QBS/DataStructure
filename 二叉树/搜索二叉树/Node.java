package binary_search_tree;

public class Node {
    Integer key;
    Node left;
    Node right;

    Node(Integer key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
