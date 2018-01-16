package Leetcode;
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
public class PartionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode dummy2 = new ListNode(-2);
        dummy.next = head;
        ListNode p = head;
        ListNode p2 = dummy2;
        ListNode h1 = dummy;
        dummy.next = head;
        ListNode h2 = dummy2;
        ListNode pre = dummy;

        while(p!= null){
            if (p.val < x){
                p = p.next;
                pre = pre.next;
            } else {
                p2.next = p;
                pre.next = p.next;
                p = pre.next;
                p2 = p2.next;
            }
            p = p.next;
        }
        p2.next = null;
        pre.next = dummy2.next;
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
