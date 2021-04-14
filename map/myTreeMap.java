package MapUse;

public class myTreeMap {
    
    private TreeNode root;

    //添加
    public Integer put(String key,Integer value) {
        if (root == null) {
            root = new TreeNode(key,value);
            return null;
        }
        TreeNode parent = null;
        TreeNode cur = root;
        int cmp = 0;
        while (cur != null) {
            cmp = key.compareTo(cur.key);
            if (cmp == 0) {
                //在搜索树中找到了该元素，替换值，返回原来的值即可
                Integer old = cur.value;
                cur.value = value;
                return old;
            } else if (cmp < 0){
                parent = cur;
                cur = cur.left;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }
        //搜索树中没找到，需要自行插入
        TreeNode node = new TreeNode(key,value);
        if (cmp < 0) {
            parent.left = node;
        } else {
            parent.right = node;
        }
        return null;
    }

    //返回 key 对应的 value
    public Integer get(String key) {
        TreeNode cur = root;
        int cmp = 0;
        while (cur != null) {
            cmp = key.compareTo(cur.key);
            if (cmp == 0) {
                //在搜索树中找到了该元素
                return cur.value;
            } else if (cmp < 0){
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        //搜索树中没找到
        return null;
    }

    public Integer getOrDefault(String key,Integer defaultValue) {
        Integer v = get(key);
        if (v != null) {
            return v;
        }
        return defaultValue;
    }
}
