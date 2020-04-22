import java.util.HashMap;
import java.util.Map;

/**
 * @author Jelly
 * @version 1.0.0
 * @ClassName L007.java
 * @Description TODO
 * @createTime 2020年04月22日 23:51:00
 */
public class L007 {
    class Solution {

        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) { val = x; }
        }

        Map<Integer, Integer> inOrderMap = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {

            if (preorder.length != inorder.length) {
                return null;
            }

            int index = 0;
            for (int i : inorder) {
                inOrderMap.put(i,index);
                index++;
            }

            return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
        }

        private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {

            if(preStart>preEnd || inStart>inEnd) {
                return null;
            }

            TreeNode root = new TreeNode(preorder[preStart]);
            int rootInOrderIndex = inOrderMap.get(root.val);
            int leftTreeLength = rootInOrderIndex - inStart;

            root.left = build(preorder, preStart+1, preStart+leftTreeLength, inorder, inStart, rootInOrderIndex-1);
            root.right = build(preorder,preStart+leftTreeLength+1, preEnd, inorder, rootInOrderIndex+1,inEnd);

            return root;
        }
    }
}
