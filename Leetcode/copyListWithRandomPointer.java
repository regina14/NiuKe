package Leetcode;
import java.util.*;

class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
  };
public class copyListWithRandomPointer {
    public static RandomListNode copyRandomList(RandomListNode head) {
        if (head == null){
            return null;
        }

        //RandomListNode newHead = new RandomListNode(head.val);
        RandomListNode p = head;
        RandomListNode next = null;
        while (p != null){
            next = p.next;
            p.next = new RandomListNode(p.label);
            p.next.next = next;
            p = next;
        }
        printNode(head);
        p = head;
        while (p != null){
            if (p.random != null){
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        printNode(head);

        RandomListNode newHead = head.next;
        p = head;
        while (p != null){
            next = p.next;
            p.next = next.next;
            next.next = p.next == null? null : p.next.next;
            p = p.next;
        }
        printNode(head);
        printNode(newHead);
        return newHead;
    }



    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(1);
        head.next = new RandomListNode(2);
        head.next.next = new RandomListNode(3);
        head.random = head.next.next;

        copyRandomList(head);
    }

    public static void printNode(RandomListNode head){
        while(head != null) {
            System.out.print(head.label + "-");
            if (head.random != null){
                System.out.print("(" + head.random.label + ")");
            }
            head = head.next;
        }
        System.out.println();
    }
}
