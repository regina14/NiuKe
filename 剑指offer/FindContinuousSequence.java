package 剑指offer;
//和为S的连续正数序列
import java.util.*;
public class FindContinuousSequence {
    public static ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum <= 2){
            return res;
        }

        int left = 1;
        int right = 2;

        while (left < (1 + sum)/2){
            int cur = getSum(left, right);
            if (cur == sum){
                ArrayList<Integer> temp = new ArrayList<>();
                for (int i = left; i <= right; i++){
                    temp.add(i);
                }
                res.add(temp);
                left++;
                right++;
            } else if (cur < sum){
                right++;
            } else{
                left++;
            }
        }
        System.out.println(res);
        return res;
    }

    public static int getSum(int s, int e){
        int sum = 0;
        for (int i = s; i <= e; i++){
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        FindContinuousSequence(100);
    }


}
