package leetcode;

/**
 *
 * @author pguan
 */
public class SortedList2AVL {
    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBST(head, null);
    }
    
    public TreeNode sortedListToBST(ListNode start, ListNode end) {
        ListNode theMiddle = getMid(start, end);
        if(theMiddle == null) {
            return null;
        }
        TreeNode toReturn = new TreeNode(theMiddle.val);
        toReturn.left = sortedListToBST(start, theMiddle);
        toReturn.right = sortedListToBST(theMiddle.next, end);
        return toReturn;
    }
    
    private ListNode getMid(ListNode head, ListNode tail) {
        if(head == tail) {
            return null;
        }
        ListNode fast=head;
        ListNode slow = head;
        while(fast!=tail && fast.next!=tail) {
            slow = slow.next;
            fast = fast.next.next;            
        }
        return slow;
    }
    public static void main(String[] args) {
        SortedList2AVL avl = new SortedList2AVL();
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(0);
        l4.next = l3;
        l3.next = l2;
        l2.next = l1;
        avl.sortedListToBST(l3);
    }
}
//class ListNode {
//
//    int val;
//    ListNode next;
//
//    ListNode(int x) {
//        val = x;
//    }
//
//}
