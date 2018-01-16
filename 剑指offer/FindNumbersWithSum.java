package 剑指offer;
import java.util.*;
//和为S的两个数字
public class FindNumbersWithSum {
    public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (array == null || array.length == 0){
            return res;
        }
        int min = Integer.MAX_VALUE;
        int len = array.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++){
            if (map.containsKey(array[i])){
                int n1 = array[map.get(array[i])];
                int n2 = array[i];

                int product = n1 * n2;
                if (product < min){
                    min = product;
                    res = new ArrayList<>();
                    int m = Math.min(n1, n2);
                    res.add(m);
                    res.add(sum - m);
                }
            }
            map.put(array[i], i);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
