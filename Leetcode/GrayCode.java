package Leetcode;
import java.lang.reflect.Array;

import java.util.*;
public class GrayCode {
    public static ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        if (n <= 0){
            res.add(0);
            return res;
        }
        if (n == 1){
            res.addAll(Arrays.asList(0, 1));
            System.out.println("after: ");
            System.out.println(res);
            return res;
        }

        ArrayList<Integer> pre = grayCode(n - 1);
        int size = pre.size();
        int add = 1 <<(n - 1);
        System.out.printf("size: %d, add: %d\n", size, add);
        System.out.println("pre: ");
        System.out.println(pre);
        for (int i = size - 1; i >= 0; i--){
            pre.add(pre.get(i) + add);
        }
        System.out.println("after: ");
        System.out.println(pre);
        return pre;
    }

    public static void main(String[] args) {
        //grayCode(1);
        //grayCode(2);
        grayCode(4);

    }
}
