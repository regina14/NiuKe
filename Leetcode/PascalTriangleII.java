package Leetcode;
import java.util.*;
public class PascalTriangleII {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> res = new ArrayList<>();
        if (rowIndex < 0){
            return res;
        }

        ArrayList<Integer> pre = new ArrayList<>();
        pre.add(1);

        for (int i = 1; i <= rowIndex; i++){
            ArrayList<Integer> cur = new ArrayList<>();
            cur.add(1);
            for (int j = 0; j < pre.size() - 1; j++){
                cur.add(pre.get(j) + pre.get(j + 1));
            }
            cur.add(1);
            pre = cur;
        }
        return pre;
    }
}
