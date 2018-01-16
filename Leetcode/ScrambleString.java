package Leetcode;
import java.util.*;

public class ScrambleString {
    public static boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)){
            return true;
        }

        if (s1 == null && s2 == null){
            return true;
        }

        if (s1 == null || s2 == null){
            return false;
        }

        if (s1.length() != s2.length()){
            return false;
        }

        int len = s1.length();
        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        if (!Arrays.equals(a1, a2)){
            return false;
        }

        for (int i = 1; i < len; i++){
            System.out.printf("i: %d\n", i);
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i);
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i);
            String s23 = s2.substring(0, len - i);
            String s24 = s2.substring(len - i);
            System.out.printf("s1: %s\n", s1);
            System.out.printf("s11: %s, s12: %s\n", s11, s12);
            System.out.printf("s2: %s\n", s2);
            System.out.printf("s21: %s, s22: %s\n", s21, s22);
            System.out.printf("s23: %s, s24: %s\n", s23, s24);
            if ((isScramble(s11, s21) && isScramble(s12, s22)) || (isScramble(s11,s24) && isScramble(s12, s23))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String t1 = "great";
        String t2 = "rgtae";
        System.out.println(isScramble(t1, t2));
    }
}
