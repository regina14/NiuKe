package Leetcode;

public class PalindromePartitionII {
    public static int minCut(String s) {
        if(s == null || s.length() == 0) return 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int[] cut = new int[n];
        for(int j = 0; j < n; j++){
            cut[j] = j;
            for(int i = 0; i <= j; i++){
                if(s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1])){
                    dp[i][j] = true;
                    if(i > 0){
                        cut[j] = Math.min(cut[j], cut[i - 1] + 1);
                    }else{
                        cut[j] = 0;
                    }
                }
            }
        }
        printMatrix(dp);
        printArrayList(cut);
        return cut[n - 1];
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

    public static void printMatrix(boolean[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        String test1 = "aab";
        String test2 = "abbab";
        minCut(test2);
    }
}
