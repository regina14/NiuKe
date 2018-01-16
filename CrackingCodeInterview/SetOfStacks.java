package CrackingCodeInterview;
import java.util.*;

public class SetOfStacks {
    public static ArrayList<ArrayList<Integer>> setOfStacks(int[][] ope, int size) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (ope == null || ope.length == 0){
            return res;
        }
        ArrayList<Integer> cur = new ArrayList<>();
        res.add(cur);
        for (int i = 0; i < ope.length; i++){
            System.out.printf("i: %d, ops: [%d, %d]\n", i, ope[i][0], ope[i][1]);
            cur = res.get(res.size() - 1);
            System.out.println(res);
            if (ope[i][0] == 1){
                if (cur.size() < size){
                    cur.add(ope[i][1]);
                }else{
                    cur = new ArrayList<>();
                    cur.add(ope[i][1]);
                    res.add(cur);
                }
                System.out.println(res);
            } else if (ope[i][0] == 2){
                if (res.get(0).size() == 0){
                    continue;
                }
                if (cur.size() == 1){
                    res.remove(res.size() - 1);
                    cur = res.get(res.size() - 1);
                } else{
                    cur.remove(cur.size() - 1);
                }

                System.out.println(res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] ops = {{1,1},{1,2},{1,3},{2,1}};
        setOfStacks(ops, 2);
    }
}
