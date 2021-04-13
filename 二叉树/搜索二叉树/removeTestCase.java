package binary_search_tree;

public class removeTestCase {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(6);

        //case1：
        //System.out.println(bst.remove(3));
        //case2：
        /*boolean s = bst.remove(5);
        System.out.println(s);*/
        //case3
        boolean s = bst.remove(3);
        System.out.println(s);
    }
}
