package leetcode;

/**
 * To judge if a BST is valid.
 * @author pguan
 */
public class ValidBST {
    public boolean isValidBST(TreeNode root) {        
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean isValidBST(TreeNode root, long min, long max) {
        if( root == null ) return true;
        if(root.val >= max || root.val <= min) return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}


 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
       val = x;
    }
 }
