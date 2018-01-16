package Leetcode;

import java.util.*;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] num) {
        if (num == null || num.length == 0){
            return 0;
        }
        int max = 0;
        int len = num.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++){
            set.add(num[i]);
        }

        printArrayList(num);
        System.out.println(set);
        for (int i = 0; i < len; i++){
            int cur = num[i];
            if (set.contains(cur)){
                set.remove(cur);
                int cnt = 1;
                while (set.contains(cur + 1)){
                    set.remove(cur + 1);
                    cur++;
                    cnt++;
                }
                cur = num[i];
                while (set.contains(cur - 1)){
                    set.remove(cur - 1);
                    cur--;
                    cnt++;
                }
                max = Math.max(cnt, max);
            }
        }
        System.out.println("max: " + max);
        return max;
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

        int[] test = {100, 4, 200, 1, 3, 2};
        longestConsecutive(test);
    }
}
