package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author pguan
 */
public class MaxDepthOfBTree {
    private int index = 0;

    private void loopByLayer(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            index++;
        }
    }
    public int maxDepth(TreeNode root) {
        loopByLayer(root);
        return index;
    }    
}