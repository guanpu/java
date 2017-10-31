package leetcode;

/**
 * Note: there's no need to implement the left-rotate or right-rotate method to build AVL, 
 * since they are sorted, just recursively make mid value be to root node.
 * @author pguan
 */
public class SortedArray2AVL {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) {
            return null;
        }else if(nums.length==1) {
            return new TreeNode(nums[0]);
        } else {
            return sortedArrayToBST(nums, 0, nums.length-1);
        }
    }
    public TreeNode sortedArrayToBST(int [] nums, int start, int end) {
        if(end<start) {
            return null;
        } else if(end==start){
            return new TreeNode(nums[end]);
        } else {
            int mid = start + (end - start>>1);
            TreeNode toReturn  = new TreeNode(nums[mid]);
            toReturn.left = sortedArrayToBST(nums, start, mid-1);
            toReturn.right = sortedArrayToBST(nums, mid+1, end);
            return toReturn;
        }
    }
    public static void main(String[] args) {
        SortedArray2AVL avl = new SortedArray2AVL();
        avl.sortedArrayToBST(new int[]{-1,0,2,3});
    }
}