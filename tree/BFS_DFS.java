package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jelly
 * @version 1.0.0
 * @ClassName BFS_DFS.java
 * @Description TODO
 * @createTime 2020年06月03日 08:09:00
 */
public class BFS_DFS {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 广度优先算法
     * 借助队列，首先插入根节点，然后开始重复执行弹出当前队首节点并添加队首节点的子节点到对位(先左后右)，知道队列为空
     * @param root
     * @return
     */
    public ArrayList<Integer> sulotion_bfs(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();
            result.add(current.val);
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }

        return result;
    }
}
