package CrackingCodeInterview;

//链表分割
public class partition {
    public static ListNode partition(ListNode pHead, int x) {
        // write code here
        if(pHead == null){
            return pHead;
        }

        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        dummy1.next = pHead;
        ListNode p = pHead;
        ListNode pre = dummy1;
        ListNode p2 = dummy2;

        while (p != null){
            if (p.val < x){
                p = p.next;
                pre = pre.next;
            } else{
                p2.next = p;
                pre.next = p.next;
                //pre = p;
                p = pre.next;
                p2 = p2.next;

            }
        }
        p2.next = null;
        pre.next = dummy2.next;
        return dummy1.next;
    }

    public static void print(ListNode head){
        while (head != null){
            System.out.print(head.val + " - ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(2);
        print(head);
        partition(head, 3);
        print(head);
    }
}
