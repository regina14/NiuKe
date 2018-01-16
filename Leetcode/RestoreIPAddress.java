package Leetcode;
import java.util.*;
public class RestoreIPAddress {
    public static ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<>();
        if (s == null || s.length() < 4){
            return null;
        }
        int len = s.length();
        for (int i = 1; i < 4 && i < len - 2; i++){
            for (int j = i + 1; j < i + 4 && j < len - 1; j++){
                for (int k = j + 1; k < j + 4 && k < len; k++){
                    String p1 = s.substring(0, i);
                    String p2 = s.substring(i, j);
                    String p3 = s.substring(j, k);
                    String p4 = s.substring(k);
                    System.out.printf("p1: %s, p2: %s, p3: %s, p4: %s\n", p1, p2, p3,p4);
                    if (isValid(p1) && isValid(p2) && isValid(p3) && isValid(p4)){
                        res.add(new String(p1 + "." + p2 + "." + p3 + "." + p4));
                    }
                }
            }
        }
        System.out.println(res);
        return res;
    }

    public static boolean isValid(String p){
        int len = p.length();
        int val = Integer.parseInt(p);
        if (len <= 0 || len > 3 || val < 0 || val > 255 || (p.charAt(0) == '0' && len > 1)){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        restoreIpAddresses("25525511135");
        restoreIpAddresses("0000");
    }
}
