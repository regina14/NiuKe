package 剑指offer;

import java.util.*;

public class PrintMinNumber {
    public static String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0){
            return "";
        }
        List<String> res = new ArrayList<>();
        for (int i : numbers){
            res.add(String.valueOf(i));
        }
        Collections.sort(res, (a, b)->((a + b).compareTo(b + a)));
        StringBuilder sb = new StringBuilder();
        for (String s: res){
            sb.append(s);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] t1 = {3, 32, 321};
        PrintMinNumber(t1);
    }
}
