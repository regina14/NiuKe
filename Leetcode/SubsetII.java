package Leetcode;
import java.util.*;
public class SubsetII {
    public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (num == null || num.length == 0){
            return res;
        }
        Arrays.sort(num);
        helper(res, num, new ArrayList<Integer>(), new boolean[num.length], 0);
        System.out.print("Final: ");
        System.out.println(res);
        return res;
    }

    private static void helper(ArrayList<ArrayList<Integer>> res, int[] num, ArrayList<Integer> list, boolean[] vis, int start) {
        if (start > num.length){
            return;
        }
        res.add(new ArrayList<>(list));
        System.out.print("res: ");
        System.out.println(res);
        for (int i = start; i < num.length; i++){
            System.out.printf("start: %d, i: %d\n", start, i);
            if (i > 0 && (num[i - 1] == num[i] && !vis[i - 1])) continue;
            vis[i] = true;
            list.add(num[i]);
            System.out.print("list: ");
            System.out.println(list);
            helper(res, num, list, vis, i + 1);
            vis[i] = false;
            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] t1 = {1, 2, 2};
        subsetsWithDup(t1);
    }

}
