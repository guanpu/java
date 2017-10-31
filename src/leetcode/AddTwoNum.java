package leetcode;

/**
 * Simulating add with the data structure of linked list.
 * @author pguan
 */
public class AddTwoNum {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode p = l1, q = l2, current = listNode;
        int addOne = 0;
        while (p != null || q != null) {
            int l1v = p != null ? p.val : 0;
            int l2v = q != null ? q.val : 0;
            ListNode theNext = new ListNode((l1v + l2v + addOne) % 10);
            addOne = (l1v + l2v + addOne) / 10;
            current.next = theNext;
            current = theNext;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }

        }
        current.next = new ListNode(addOne);
        return listNode.next;
    }
    
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(7);
        AddTwoNum adt = new AddTwoNum();
        System.out.println(adt.addTwoNumbers(l1,l2).val);
    }
}

class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

}
