package CrackingCodeInterview;

//访问单个节点的删除
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}


public class removeNode {
    public static boolean removeNode(ListNode pNode) {
        // write code here
        if(pNode == null || pNode.next == null){
            return false;
        }
        ListNode next = pNode.next;
        pNode.val = next.val;
        pNode.next = next.next;

        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        print(head);
        removeNode(head.next);
        print(head);


    }

    public static void print(ListNode head){
        while (head != null){
            System.out.print(head.val + " - ");
            head = head.next;
        }
        System.out.println();
    }
}
