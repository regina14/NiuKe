package CrackingCodeInterview;

//链式A+B
public class plusAB {
    public static ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        int sum = 0;
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while (a != null || b != null){
            if (a != null){
                sum += a.val;
                a = a.next;
            }

            if (b != null){
                sum += b.val;
                b = b.next;
            }

            p.next = new ListNode(sum % 10);
            p = p.next;
            sum /= 10;
        }
        if (sum != 0) p .next = new ListNode(1);
        return head.next;
    }

    public static void print(ListNode head){
        while (head != null){
            System.out.print(head.val + " - ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);

        ListNode head2= new ListNode(3);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(1);
        print(head1); print(head2);
        print(plusAB(head1, head2));


    }
}
