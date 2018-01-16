package Leetcode;
import java.util.*;
public class RemoveDuplicatesFromSortedArrayII {
    public static int removeDuplicates(int[] A) {
        if (A == null || A.length <= 2){
            return A.length;
        }

        int p1 = 1;
        int p2 = 2;
        int len = A.length;
        while(p2 < len){
            System.out.printf("A[p1: %d]: %d, A[p2: %d]: %d, A[p2 - 1: %d]: %d, A[p2 - 2: %d]: %d\n", p1, A[p1], p2, A[p2], p2 - 1, A[p2 - 1], p2 - 2, A[p2 - 2]);
            if (A[p2] == A[p2 - 1] && A[p2] == A[p2 - 2]){
                System.out.println("after: " + (p2 + 1));
                p2++;
            } else{
                System.out.println("***");
                printArrayList(A);
                p1++;
                A[p1] = A[p2];
                p2++;
                System.out.printf("A[p1: %d]: %d, A[p2: %d]", p1, A[p1], p2);
                printArrayList(A);
                System.out.println("***");
            }
        }
        return p1 + 1;
    }

    public static void printArrayList(int[] nums) {
        System.out.print("Array List: ");
        if(nums != null){
            for(int n: nums) {
                System.out.print(n  + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[] t = {1, 1, 2, 2, 3};
        System.out.println(removeDuplicates(t));
    }
}
