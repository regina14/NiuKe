package CrackingCodeInterview;
import java.util.*;

public class twoStacksSort {
    public static ArrayList<Integer> twoStacksSort(int[] numbers) {
        // write code here
       Deque<Integer> stk1 = new ArrayDeque<>();
       Deque<Integer> stk2 = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>();
       int len = numbers.length;
       for (int i = 0; i < len; i++){
           stk1.push(numbers[i]);
       }
       while(!stk1.isEmpty()){
           int cur = stk1.pop();
           while (!stk2.isEmpty() && cur < stk2.peek()){
                   stk1.push(stk2.pop());
           }
           stk2.push(cur);
       }

       while(!stk2.isEmpty()){
           res.add(stk2.pop());
       }

       return res;
    }

    public static void main(String[] args) {
        int[] t1 = {1, 2, 3, 4, 5};
        twoStacksSort(t1);
    }
}
