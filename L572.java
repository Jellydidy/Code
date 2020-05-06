/**
 * @author Jelly
 * @version 1.0.0
 * @ClassName L572.java
 * @Description 判断树t中是否包含与树s相同的子树
 * @createTime 2020年05月07日 00:33:00
 */
public class L572 {

    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int v) {
            this.val = v;
        }
    }
    public boolean isSubTree(TreeNode t, TreeNode s) {
        if (t == null && s == null) {
            return true;
        }
        if (t == null || s == null) {
            return false;
        }
        if (isEqual(t, s)) {
            return true;
        }

        return isSubTree(t.left, s) || isSubTree(s.right, s);
    }

    private boolean isEqual(TreeNode  t, TreeNode s) {
        if (t == null && s == null) {
            return true;
        }
        if (t == null || s == null) {
            return  false;
        }
        if (t.val == s.val) {
            return  isEqual(t.left, s.left) && isEqual(t.right, s.right);
        }

        return  false;
    }
}
