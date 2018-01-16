package Leetcode;

public class DecodeWays {
    public static int numDecodings(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = isValid(s.substring(0, 1))? 1 : 0;

        for (int i = 2; i <= len; i++){
            if (isValid(s.substring(i - 1, i))){
                dp[i] += dp[i - 1];
            }
            if (isValid(s.substring(i - 2, i))){
                dp[i] += dp[i - 2];
            }
        }
        printArrayList(dp);

        return dp[len];
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

    public static boolean isValid(String s){
        int val = Integer.parseInt(s);
        int len = s.length();
        if (val <= 0 || val > 26 || (len > 1 && s.charAt(0) == '0')){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        numDecodings("12");
    }
}
