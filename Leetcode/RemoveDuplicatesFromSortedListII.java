package Leetcode;


public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = head;
        while(p.next != null && p.next.next != null){
            if (p.next.val == p.next.next.val){
                    int dup = p.next.val;
                    while (p.next != null && p.next.val == dup){
                        p.next = p.next.next;
                    }
            }else{
                p = p.next;
            }
        }
        return dummy.next;
    }
}
