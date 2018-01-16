package Leetcode;

import java.util.List;

public class RemoveDuplicatesFromSortedList {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode p = head;
        //print(head);
        while(p.next != null){
            if(p.val == p.next.val){
                p.next = p.next.next;
            } else{
                p = p.next;
            }
        }
        //print(head);
        return head;
    }

    public static void print(ListNode head){
        while(head != null){
            System.out.print(head.val + " | ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        deleteDuplicates(head);

    }
}
