package tree;

/**
 * @author Jelly
 * @version 1.0.0
 * @ClassName L124.java
 * @Description TODO
 * @createTime 2020年06月18日 00:35:00
 */
public class L124 {


     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
    class Solution {
         public int max = Integer.MIN_VALUE;
         public int maxPathSum(TreeNode root) {
             helper(root);
             return max;
         }
         private int helper(TreeNode cur) {
             if (cur == null) { return 0; }
             int left = Math.max(helper(cur.left), 0);
             int right = Math.max(helper(cur.right), 0);
             max = Math.max(max, cur.val+left+right);
             return cur.val + Math.max(left, right);
         }


    }
}
