package 剑指offer;
//构建乘积数组

import java.util.Arrays;

public class multiplyArray {

    //TC: O(n)
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        if(nums == null || nums.length == 0) return res;
        res[0] = 1;
        for(int i = 1; i < nums.length; i++){
            res[i] = res[i - 1]* nums[i - 1];
        }

        int right = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }

    //TC: O(n^2)
    public static int[] multiplyRZ(int[] A) {
		int[] res = new int[A.length];
		int len = A.length;
        Arrays.fill(res, 1);
        for (int i = 0; i < len; i++){
		    for (int j = 1; j < len; j++){
		        res[i] *= A[(i + j) % len];
            }
        }
        printArray(res);
        return res;
    }

    public static void printArray(int[] nums) {
        System.out.print("Array List: ");
        if(nums != null){
            for(int n: nums) {
                System.out.print(n  + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] t1 = {1, 2, 3, 4, 5};
        int[] expect = new int[5];
        for (int i  = 0; i < expect.length; i++){
            expect[i] = 120 / t1[i];
        }
        printArray(expect);
        //multiply(t1);
    }
}
