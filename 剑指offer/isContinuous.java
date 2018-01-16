package 剑指offer;
import java.util.*;

public class isContinuous {
    public static boolean isContinuous(int [] numbers) {
        BitSet vis = new BitSet(5);
        int len = numbers.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++){
            if (numbers[i] == 0) continue;

            max = Math.max(numbers[i], max);
            min = Math.min(numbers[i], min);
            if (max - min >= 5){
                return false;
            }
            if (vis.get(numbers[i])){
                return false;
            }
            vis.set(numbers[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isContinuous(new int[]{0, 2, 0, 0, 9}));
    }

}
