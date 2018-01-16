package Leetcode;

public class SearchInRotatedSortedArray {
    public static boolean search(int[] A, int target) {
        if (A == null || A.length == 0){
            return false;
        }
        int len = A.length;
        //System.out.printf("left: %d, right: %d\n", 0, len - 1);
        return helper(A, 0, len - 1, target);
    }

    private static boolean helper(int[] A, int left, int right, int target) {

        if (right < left){
            //System.out.printf("out of bountry left: %d, right: %d, return\n", left, right);
            return false;
        }
        int mid = left + (right - left) / 2;
        //System.out.printf("A[left: %d]: %d, A[right: %d]: %d, A[mid %d]: %d\n", left, A[left], right, A[right],mid, A[mid]);
        if (A[mid] == target){
            return true;
        }

        if (A[left] < A[mid]){
            if (A[left] <= target && target < A[mid]){
                //System.out.printf("A[left: %d]: %d, target: %d, A[mid: %d]: %d\n", left, A[left], target, mid, A[mid]);
                //System.out.printf("left: %d, right: %d\n", left, mid - 1);
                return helper(A, left, mid - 1, target);
            } else {
                //System.out.printf("A[left: %d]: %d, target: %d, A[mid: %d]: %d\n", left, A[left], target, mid, A[mid]);
                //System.out.printf("left: %d, right: %d\n", mid + 1, right);
                return helper(A, mid + 1, right, target);
            }
        } else if (A[left] > A[mid]){
            if (A[mid] < target && target <= A[right]){
                //System.out.printf("A[mid: %d]: %d, target: %d, A[right: %d]: %d\n", mid, A[mid], target,right, A[right]);
                //System.out.printf("left: %d, right: %d\n", mid + 1, right);
                return helper(A, mid + 1, right, target);
            } else {
                //System.out.printf("A[mid: %d]: %d, target: %d, A[right: %d]: %d\n", mid, A[mid], target,right, A[right]);
                //System.out.printf("left: %d, right: %d\n", left, mid - 1);
                return helper(A, left, mid - 1, target);
            }
        } else{
            //System.out.printf("A[left: %d]: %d, A[right: %d]: %d, A[mid %d]: %d\n", left + 1, A[left + 1], right, A[right],mid, A[mid]);
            left++;
            return helper(A, left, right, target);
        }
    }

    public static void main(String[] args){
        int[] t1 = {5, 6, 1, 2, 3, 4, 4, 4, 5};
        int target = 5;
        System.out.println(search(t1, target));
    }


}
