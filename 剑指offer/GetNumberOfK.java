package 剑指offer;

import java.util.Arrays;

//数字在排序数组中出现的次数
public class GetNumberOfK {
    public static int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0){
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        for (int n: array){
            sb.append(String.valueOf(n));
        }
        System.out.println(sb.toString());
        int start = sb.indexOf(String.valueOf(k));
        int end = sb.lastIndexOf(String.valueOf(k));
        if (start == -1 && end == -1){
            return 0;
        }
        int cnt = end - start + 1;
        System.out.printf("cnt: %d\n", cnt);
        return cnt;
    }

    public static void main(String[] args) {
        int[] t1 = {1, 1, 1, 1, 1, 2, 2, 2, 3};
        int[] t2 = {1, 1, 1};
        GetNumberOfK(t1, 2);
        GetNumberOfK(t2, 2);

    }
}
