package Leetcode;
import java.util.*;

public class wordBreakII {
    public static ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> res = new ArrayList<>();
        Map<String, ArrayList<String>> map = new HashMap<>();
        if (s == null || s.length() == 0){
            return res;
        }

        return helper(map, dict, s);
    }

    public static ArrayList<String> helper(Map<String, ArrayList<String>> map, Set<String> dict, String s){
        if (map.containsKey(s)){
            return map.get(s);
        }
        ArrayList<String> temp = new ArrayList<>();
        int len = s.length();
        if (len <= 0){
            return temp;
        }

        for (int i = len - 1; i >= 0; i--){
            String pre = s.substring(i, len); //mark
            if (dict.contains(pre)){
                if (i == 0){
                    temp.add(pre);
                } else {
                    String sub = s.substring(0, i);
                    List<String> subList = helper(map, dict, sub);
                    for (String ss: subList){
                        ss = ss + " " + pre;
                        temp.add(ss);
                    }
                }
            }
        }
        map.put(s, temp);
        return temp;

    }
    public static void main(String[] args) {
        String s = "catsanddog";
        Set<String> set = new HashSet<>();
        set.add("cat");
        set.add("and");
        set.add("dog");
        set.add("sand");
        set.add("cats");
        System.out.println(wordBreak(s, set));
    }
}
