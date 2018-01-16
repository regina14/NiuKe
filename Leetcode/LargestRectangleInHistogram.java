package Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram {
    public static int largestRectangleArea(int[] height) {
        if (height  == null || height.length == 0){
            return 0;
        }
        int i = 0;
        int len = height.length;
        int max = 0;
        Deque<Integer> stk = new ArrayDeque<>();

        while(i <= len){

            int curHeight = i == len? 0 : height[i];
            System.out.printf("*****i: %d, curHeight: %d\n", i, curHeight);
            if (stk.isEmpty() || (height[stk.peek()] <= curHeight)){
                System.out.printf("push: %d\n", i);
                stk.push(i++);
                System.out.println(stk);
            } else {
                int c = stk.pop();
                int l = stk.isEmpty()? i : i - stk.peek() - 1;
                max = Math.max(max, height[c] * l);
                System.out.printf("pop c: %d, cHeight: %d * l: %d = %d, max = %d\n", c, height[c], l, height[c] * l, max);
            }
        }
        System.out.println(max);
        return max;
    }

    public static void main(String[] args) {
        int[] test = {2, 1, 5,6, 2, 3};
        largestRectangleArea(test);
    }
}
