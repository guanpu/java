package leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 *
 * @author pguan
 */
public class SymetricTree {
    /**
     * Definition for a binary tree node. 
     * public class TreeNode {
     *   int val;
     * 
     *   TreeNode left;
     *   TreeNode right;
     *   TreeNode(int x) {
     *     val = x; 
     *   } 
     * }
     */
    public boolean isSymmetric(TreeNode root) {
        return inOrderTraversal(root, root);
    }

    ;
    private boolean inOrderTraversal(TreeNode root, TreeNode root2) {
        if (root == null && root2 == null) {
            return true;
        } else if (root != null && root2 != null && root.val == root2.val) {
            return inOrderTraversal(root.left, root2.right) && inOrderTraversal(root.right, root2.left);
        }
        return false;
    }
}
