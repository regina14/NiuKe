package Leetcode;

public class MergeSortedArray {
    public static void merge(int A[], int m, int B[], int n) {

        while(m > 0){

            //System.out.printf("m: %d, n: %d, A[m - 1]: %d, B[n - 1]: %d\n", m, n, A[m-1], B[n - 1]);
            A[m + n - 1] = (n <= 0 || B[n - 1] < A[m - 1] )? A[--m] : B[--n];
            printArrayList(A);
        }

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

    public static void main(String[] args) {
        int[] A = {1, 3, 7, -1, -1,-1};
        int[] B = {2, 6, 10};
        merge(A, 3, B, 3);
    }
}
