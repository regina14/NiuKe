package Leetcode;
import java.util.*;
public class MaximalRectangle {
    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix[0].length == 0){
            return 0;
        }
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] height = new int[r][c];

        printMatrix(matrix);
        System.out.println();

        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if (matrix[i][j] == '1'){
                    height[i][j] = i == 0? 1 : height[i - 1][j] + 1;
                } else{
                    height[i][j] = 0;
                }
            }
        }
        printMatrix2(height);

        int max = 0;
        for(int i = 0; i < r; i++){
            System.out.print("****i: " + i + ":");
            printArrayList(height[i]);
            max = Math.max(max, getArea(height[i]));
            System.out.println("****max: " + max + ":");
        }
        return max;
    }

    public static int getArea(int[] height){
        Deque<Integer> stk = new ArrayDeque<>();
        int len = height.length;
        int max = 0;
        int i = 0;
        while(i <= len){
            int cur = i == len? 0 : height[i];
            System.out.printf("i: %d, cur: %d\n", i, cur);
            System.out.print("stk: ");
            System.out.println(stk);
            if (stk.isEmpty() ||height[stk.peek()] <= cur){
                stk.push(i);
                System.out.printf("stk push: %d\n", i);
                System.out.println(stk);
                i++;

            } else{
                int c = stk.pop();
                System.out.printf("stk pop: %d\n", c);
                System.out.println(stk);
                int l = stk.isEmpty()? i : i - stk.peek() - 1;

                max = Math.max(max,  height[c] * l);
                System.out.printf("cur: %d * l: %d = %d\n", height[c], l, max);

            }
        }
        return max;
    }

    public static void printMatrix(char[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printMatrix2(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
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


    public static void main(String[] args){
        char[][] test = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        maximalRectangle(test);
    }
}
